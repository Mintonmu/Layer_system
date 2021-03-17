package com.sxl.controller.admin;

import com.sxl.controller.MyController;
import com.sxl.controller.suanfa.Aprioti;
import com.sxl.controller.suanfa.Itemset;
import com.sxl.util.StringHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@Controller("frontController")
@RequestMapping(value = "/front")
public class FrontController extends MyController {

    @RequestMapping(value = "/index")
    public String frame(Model model, HttpServletRequest request)
            throws Exception {
        String sql = "select a.*,(select name from t_user b where b.id=a.userId) name from t_product a where 1=1 order by id desc limit 4";
        List list = db.queryForList(sql);
        System.out.println(list);
        request.setAttribute("list", list);

        //java推荐算法
        tuijiansuanfa(request);


        sql = "select * from t_lbt";
        List list3 = db.queryForList(sql);
        request.setAttribute("list3", list3);
        return "/front/index";
    }

    /**
     * 专门有个算法包
     * 然后算法的逻辑也在这里，
     * 而且把算法之外额逻辑也加了
     * 注！为了应对一开始人员访问数据量不够推荐算法使用的情况，就进行了数据补足，这个业务逻辑就非常完美了。
     * <p>
     * java推荐算法
     *
     * @param request
     */
    public void tuijiansuanfa(HttpServletRequest request) {
        Itemset originalItem = new Itemset();
        List<Map> lista = db.queryForList("select * from t_customer");
        for (int i = 0; i < lista.size(); i++) {
            TreeSet<String> itemset = new TreeSet<String>();
            List<Map> listb = db.queryForList("select * from t_productclick where customerId=?", new Object[]{lista.get(i).get("id")});
            for (int j = 0; j < listb.size(); j++) {
                itemset.add(listb.get(j).get("productId") + "");
            }
            originalItem.itemset.add(itemset);
        }
        Aprioti.originalItem = originalItem;
        List<Long> outList = Aprioti.aprioriProcess();
        String in = "";
        if (outList != null && outList.size() > 0) {
            for (int i = 0; i < outList.size(); i++) {
                in += "," + outList.get(i);
            }
        }
        String sqlall = "select a.*,(select name from t_user b where b.id=a.userId) name  from t_product a where 1=1 ";
        String sql = sqlall;
        if (in != null && !"".equals(in)) {
            sql += " and id in (" + in.substring(1) + ")";
        }
        sql += "  order by rand() limit 8 ";
        //以上推荐算法最总结果在根据随机安排推荐

        //注！为了应对一开始人员访问数据量不够推荐算法使用的情况，就进行了数据补足，这个业务逻辑就非常完美了。
        List tuijianList = db.queryForList(sql);
        int a = 8;
        int b = 0;
        if (tuijianList == null || tuijianList.size() < 8) {
            if (tuijianList != null) {
                b = 8 - tuijianList.size();
            }
            List list2 = db.queryForList(sqlall + " order by rand() limit " + b);
            tuijianList.addAll(list2);
        } else {

        }
        request.setAttribute("tuijianList", tuijianList);
    }

    @RequestMapping(value = "/login")
    public String login(Model model, HttpServletRequest request)
            throws Exception {
        return "/front/login";
    }

    @RequestMapping(value = "/all")
    public String all(Model model, HttpServletRequest request, Long typesId, String productName, String px)
            throws Exception {

        String sql = "select a.* from t_types a where 1=1";
        sql += " order by id desc";
        List typesList = db.queryForList(sql);
        request.setAttribute("typesList", typesList);
        sql = "select a.*,(select typesName from t_types b where a.typesId=b.id) typesName,(select name from t_user b where b.id=a.userId) name  from t_product a where 1=1";

        if (typesId != null && !"".equals(typesId)) {
            sql += " and a.typesId=" + typesId;
        }
        if (productName != null && !"".equals(productName)) {
            sql += " and a.productName like '%" + productName + "%' ";
        }
        if ("1".equals(px)) {
            sql += " order by id desc";
        } else if ("2".equals(px)) {
            sql += " order by price asc";
        } else if ("3".equals(px)) {
            sql += " order by price desc";
        } else if ("4".equals(px)) {
            sql += " order by djl desc";
        }

        List list = db.queryForList(sql);
        request.setAttribute("list", list);

        return "/front/all";
    }

    @RequestMapping(value = "/jfdh")
    public String jfdh(Model model, HttpServletRequest request)
            throws Exception {

        String sql = "select a.* from t_jfdh a where 1=1";

        sql += " order by id desc";
        List list = db.queryForList(sql);
        request.setAttribute("list", list);
        return "/front/jfdh";
    }

    @RequestMapping(value = "/dhjfSave")
    public ResponseEntity<String> dhjfSave(Model model,
                                           HttpServletRequest request, Long id) throws Exception {
        Map map = db.queryForMap("select * from t_jfdh where id=" + id);
        String jf = map.get("jfCost").toString();
        String jfName = map.get("jfName").toString();
        //订单
        String sql = "insert into t_order(orderNum,customerId,productDetail,allPrice,status,insertDate) values(?,?,?,?,?,now())";
        int result = db.update(sql, new Object[]{System.currentTimeMillis() + "",
                getCustomer(request).get("id").toString(), jfName + "积分兑换[" + jf + "]", 0 + "", "兑换完成"});
        sql = "update t_customer set jf = jf-" + jf + " where id=" + getCustomer(request).get("id");
        db.update(sql);

        //积分减少
        return renderData(true, "操作成功", null);
    }


    @RequestMapping(value = "/register")
    public String register(Model model, HttpServletRequest request)
            throws Exception {
        System.out.println("112312312");
        return "/front/register";
    }

    @RequestMapping(value = "/liaotian")
    public String liaotian(Model model, HttpServletRequest request)
            throws Exception {
        return "/front/liaotian";
    }

    public void saveClick(HttpServletRequest request, Long id) {
        String sql = "insert into t_productclick(productId,customerId,insertDate) values(?,?,now())";
        Map customer = getCustomer(request);
        if (customer != null && customer.size() > 0) {
            db.update(sql, new Object[]{id, getCustomer(request).get("id")});
        }
    }

    @RequestMapping(value = "/detail")
    public String detail(Model model, HttpServletRequest request, Long id)
            throws Exception {
        //保存点击
        saveClick(request, id);
        String sql = "select a.*,(select typesName from t_types b where a.typesId=b.id) typesName," +
                "(select name from t_user b where b.id=a.userId) name from t_product a where id=" + id;
        Map map = db.queryForMap(sql);
        request.setAttribute("map", map);
        String sql2 = "select a.*,(select max(customerName) from t_customer b where a.customerId=b.id) customerName from t_pinglun_product a where productId=? order by id desc";
        List<Map> list = db.queryForList(sql2, new Object[]{id});
        model.addAttribute("list", list);
        db.update("update t_product set djl=djl+1 where id=" + id);

        int scNum = db.queryForInt("select count(1) stringval from t_sc where productId=" + id);
        model.addAttribute("scNum", scNum);
        return "/front/detail";
    }

    @RequestMapping(value = "/myOrder")
    public String myOrder(Model model, HttpServletRequest request)
            throws Exception {
        String sql = "select a.*,(select max(customerName) from t_customer b where a.customerId=b.id) customerName,(select max(name) from t_user b where a.userId=b.id) name  from t_wdxx a where 1=1 ";

        if (1 == 1) {
            sql += "and customerId=" + getCustomer(request).get("id") + " ";
        }
        sql += " order by id desc";
        List list = db.queryForList(sql);
        request.setAttribute("orderList", list);
        return "/front/myOrder";
    }


    @RequestMapping(value = "/deleteOneOrder")
    public ResponseEntity<String> deleteOneOrder(Model model,
                                                 HttpServletRequest request, Long id) throws Exception {
        String sql = "delete from t_order where id=" + id;
        db.update(sql);
        return renderData(true, "操作成功", null);
    }

    @RequestMapping(value = "/pjSave")
    public ResponseEntity<String> pjSave(Model model,
                                         HttpServletRequest request, Long id, String pj) throws Exception {
        String sql = "update t_wdxx set pj='" + pj + "'  where id=" + id;
        db.update(sql);
        return renderData(true, "操作成功", null);
    }


    @RequestMapping(value = "/deletesc")
    public ResponseEntity<String> deletesc(Model model,
                                           HttpServletRequest request, Long id) throws Exception {
        String sql = "delete from t_sc where id=" + id;
        db.update(sql);
        return renderData(true, "操作成功", null);
    }

    @RequestMapping(value = "/deletexiaoxi")
    public ResponseEntity<String> deletexiaoxi(Model model,
                                               HttpServletRequest request, Long id) throws Exception {
        String sql = "delete from t_xiaoxi where id=" + id;
        db.update(sql);
        return renderData(true, "操作成功", null);
    }


    @RequestMapping(value = "/addShopcar")
    public ResponseEntity<String> addShopcar(Model model,
                                             HttpServletRequest request, Long id, Integer num) throws Exception {
        int result = 0;
        // 判断该用户是否
        String sql = "select * from t_shopcar where  productId=? and customerId=?";
        Map map = db.queryForMap(sql, new Object[]{id.toString(),
                getCustomer(request).get("id").toString()});
        if (map != null && map.size() > 0) {
            sql = "update t_shopcar set productId=?,num=num+" + num
                    + " where id=?";
            result = db.update(sql, new Object[]{id, map.get("id")});
        } else {
            sql = "insert into t_shopcar(productId,num,customerId) values(?,?,?)";
            result = db.update(sql, new Object[]{id, num,
                    getCustomer(request).get("id").toString()});
        }
        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }
    }

    @RequestMapping(value = "/checkIsLogin")
    public ResponseEntity<String> checkIsLogin(Model model,
                                               HttpServletRequest request) throws Exception {
        Map customer = getCustomer(request);
        if (customer != null && customer.size() > 0) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }
    }

    @RequestMapping(value = "/pay")
    public ResponseEntity<String> pay(Model model, HttpServletRequest request, Long address)
            throws Exception {
        String sql = "select a.*,(select productName from t_product b where a.productId=b.id) productName,"
                + "(select price from t_product b where a.productId=b.id) price,(select jf from t_product b where a.productId=b.id) jf  from t_shopcar a where customerId="
                + getCustomer(request).get("id");
        sql += " order by id desc";
        List<Map> list = db.queryForList(sql);
        int total = 0;
        int jf = 0;
        String productDetail = "";
        for (int i = 0; i < list.size(); i++) {
            productDetail += "," + list.get(i).get("productName") + "["
                    + list.get(i).get("num") + "]";
            total += Integer.parseInt(list.get(i).get("price").toString())
                    * Integer.parseInt(list.get(i).get("num").toString());

//			jf+=Integer.parseInt(list.get(i).get("jf").toString())
//					* Integer.parseInt(list.get(i).get("num").toString());

            String sql2 = "update t_product set nums=nums-" + list.get(i).get("num").toString() + " where id=" + list.get(i).get("productId").toString();
            db.update(sql2);
        }
        total += 20;

        Map addressMap = db.queryForMap("select * from t_address where id=?", new Object[]{address});
        sql = "insert into t_order(orderNum,customerId,productDetail,allPrice,status,insertDate,lxr,lxfs,address) values(?,?,?,?,?,now(),?,?,?)";
        int result = db.update(sql, new Object[]{System.currentTimeMillis() + "",
                getCustomer(request).get("id").toString(), productDetail.subSequence(1, productDetail.length()), total + "", "等待处理", addressMap.get("lxr"), addressMap.get("phone"), addressMap.get("xxdz")});

        sql = "delete from t_shopcar where customerId="
                + getCustomer(request).get("id");
        db.update(sql);

        sql = "update t_customer set jf = jf+" + jf + ",account=account-" + total + " where id=" + getCustomer(request).get("id");
        db.update(sql);


        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }
    }

    @RequestMapping(value = "/shopcar")
    public String shopcar(Model model, HttpServletRequest request)
            throws Exception {

        Map customer = getCustomer(request);
        if (customer != null && customer.size() > 0) {
        } else {
            return "redirect:/front/register.html";
        }
        String sql = "select a.* from t_address a where 1=1";
        if (1 == 1) {
            sql += " and customerId=" + getCustomer(request).get("id") + " ";
        }
        sql += " order by id desc";
        List addressList = db.queryForList(sql);
        request.setAttribute("addressList", addressList);

        sql = "select b.*,a.id ids,a.num num   from t_shopcar a left join t_product b on a.productId=b.id  where 1=1 and customerId="
                + getCustomer(request).get("id");
        sql += " order by id desc";
        System.out.println(sql);
        List<Map> list = db.queryForList(sql);
        request.setAttribute("list", list);
        System.out.println(list);
        int total = 0;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                total += Integer.parseInt(list.get(i).get("price").toString())
                        * Integer.parseInt(list.get(i).get("num").toString());
            }
        }

        request.setAttribute("total", total);
        return "/front/shopcar";
    }

    @RequestMapping(value = "/save")
    public ResponseEntity<String> loginSave(Model model,
                                            HttpServletRequest request, String username, String password)
            throws Exception {
        String sql = "select * from t_customer where username=?";
        List<Map> list = db.queryForList(sql, new Object[]{username});
        String result = "1";
        if (list != null && list.size() > 0) {
            Map map = list.get(0);
            if (StringHelper.get(map, "password").equals(password)) {
                request.getSession().setMaxInactiveInterval(60 * 60 * 24);
                request.getSession().setAttribute("customerBean", map);
                result = "1";
            } else {
                result = "0";
            }
        } else {
            result = "0";
        }
        return renderData(true, result, null);
    }


    @RequestMapping(value = "/deleteOneShopCar")
    public ResponseEntity<String> deleteOneShopCar(Model model,
                                                   HttpServletRequest request, Long id)
            throws Exception {
        String sql = "delete from t_shopcar where id=" + id;
        db.update(sql);
        return renderData(true, "", null);
    }

    @RequestMapping(value = "/updateShopCar")
    public ResponseEntity<String> updateShopCar(Model model,
                                                HttpServletRequest request, Long id, Integer num)
            throws Exception {
        String sql = "update t_shopcar set num=" + num + " where id=" + id;
        System.out.println(sql);
        db.update(sql);
        return renderData(true, "", null);
    }

    @RequestMapping(value = "/registerSave")
    public ResponseEntity<String> registerSave(Model model,
                                               HttpServletRequest request, Long id, String username,
                                               String password, String customerName, String sex, String address, String headPic,
                                               String phone) throws Exception {
        int result = 0;
        headPic = "resource/front4/123.jpg";
        String sql = "insert into t_customer(username,password,customerName,sex,address,phone,headPic) values(?,?,?,?,?,?,?)";
        result = db.update(sql, new Object[]{username, password, customerName, sex,
                address, phone, headPic});
        sql = "select * from t_customer order by id desc limit 1";
        List<Map> list = db.queryForList(sql);
        request.getSession().setMaxInactiveInterval(60 * 60 * 24);
        request.getSession().setAttribute("customerBean", list.get(0));

        return renderData(true, "操作成功", null);
    }

    @RequestMapping(value = "/out")
    public String out(Model model, HttpServletRequest request) throws Exception {
        request.getSession().removeAttribute("customerBean");
        return "redirect:/front/login.html";
    }

    @RequestMapping(value = "/mine")
    public String mine(Model model, HttpServletRequest request)
            throws Exception {
        Map customer = getCustomer(request);
        Map map = db.queryForMap("select * from t_customer where id=?",
                new Object[]{customer.get("id")});
        model.addAttribute("customer", map);
        return "/front/mine";
    }

    @RequestMapping(value = "/mineSave")
    public ResponseEntity<String> mineSave(Model model,
                                           HttpServletRequest request, Long id, String username,
                                           String password, String customerName, String sex, String address, String headPic,
                                           String phone) throws Exception {
        int result = 0;
        String sql = "update t_customer set customerName=?,sex=?,address=?,phone=?,headPic=? where id=?";
        result = db
                .update(sql, new Object[]{customerName, sex, address, phone, headPic, id});
        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }
    }

    @RequestMapping(value = "/password")
    public String password(Model model, HttpServletRequest request)
            throws Exception {
        return "/front/password";
    }

    @RequestMapping(value = "/changePassword")
    public ResponseEntity<String> changePassword(Model model,
                                                 HttpServletRequest request, String oldPassword, String newPassword)
            throws Exception {
        Map customer = getCustomer(request);
        if (oldPassword.equals(customer.get("password").toString())) {
            String sql = "update t_customer set password=? where id=?";
            db.update(sql, new Object[]{newPassword, customer.get("id")});
            return renderData(true, "1", null);
        } else {
            return renderData(false, "1", null);
        }
    }


    @RequestMapping(value = "/scSave")
    public ResponseEntity<String> scSave(Model model,
                                         HttpServletRequest request, Long id, String pl) throws Exception {
        int result = 0;
        String customerId = getCustomer(request).get("id").toString();
        db.update("delete from t_sc  where productId=? and customerId=? ", new Object[]{id, customerId});
        String sql = "insert into t_sc(productId,customerId,insertDate) values(?,?,now())";
        result = db.update(sql, new Object[]{id, customerId});
        return renderData(true, "操作成功", null);
    }

    @RequestMapping(value = "/plSave")
    public ResponseEntity<String> plSave(Model model,
                                         HttpServletRequest request, Long id, String pl) throws Exception {
        int result = 0;
        String sql = "update t_order set pl=? where id=?";
        result = db.update(sql, new Object[]{pl, id});
        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }
    }

    @RequestMapping(value = "/contact")
    public String fk(Model model, HttpServletRequest request) throws Exception {
        String sql = "select * from t_user";
        model.addAttribute("userList", db.queryForList(sql));
        return "/front/contact";
    }

    @RequestMapping(value = "/contactSave")
    public ResponseEntity<String> contactSave(Model model,
                                              HttpServletRequest request, String content, String phone, Long userId)
            throws Exception {
        int result = 0;
        String sql = "insert into t_contact(customerId,phone,content,insertDate,userId) values(?,?,?,now(),?)";
        result = db.update(sql, new Object[]{getCustomer(request).get("id"),
                phone, content, userId});
        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }
    }

    @RequestMapping(value = "/message")
    public String message(Model model, HttpServletRequest request)
            throws Exception {

        String sql = "select a.*,(select max(name) from t_customer b where a.customerId=b.id) customerName  from t_message a where 1=1 ";
        sql += " and customerId=" + getCustomer(request).get("id") + " ";
        sql += " order by id desc";
        List list = db.queryForList(sql);
        request.setAttribute("list", list);
        System.out.println(list);
        return "/front/message";
    }

    @RequestMapping(value = "/saveMessageContent")
    public ResponseEntity<String> saveMessageContent(Model model,
                                                     HttpServletRequest request, String messageContent) throws Exception {
        Map customer = getCustomer(request);

        String sql = "insert into t_message(customerId,messageContent,insertDate,types) values(?,?,now(),1)";//1代表我
        int result = db
                .update(sql, new Object[]{getCustomer(request).get("id"),
                        messageContent});
        return renderData(true, "1", null);
    }

    ///前端增删改查例子开始//////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/test")
    public String test(Model model, HttpServletRequest request, String flag, String testName) throws Exception {
        String sql = "select a.*,(select max(name) from t_customer b where a.customerId=b.id) customerName  from t_test a where 1=1";
        if (testName != null && !"".equals(testName)) {
            sql += " and testName like '%" + testName + "%' ";
        }
        sql += "  and customerId=" + getCustomer(request).get("id");
        sql += " order by id desc";
        List list = db.queryForList(sql);
        request.setAttribute("list", list);
        return "/front/test";
    }

    @RequestMapping(value = "/testaddSave")
    public ResponseEntity<String> testaddSave(Model model, HttpServletRequest request, Long id, String flag
            , Integer customerId, String testName, String testContent, String testSex, String testDay, String testPic, String insertDate) throws Exception {
        int result = 0;
        if (id != null) {
            String sql = "update t_test set testName=?,testContent=?,testSex=?,testDay=?,testPic=? where id=?";
            result = db.update(sql, new Object[]{testName, testContent, testSex, testDay, testPic, id});
        } else {
            String sql = "insert into t_test(customerId,testName,testContent,testSex,testDay,testPic,insertDate) values(?,?,?,?,?,?,now())";
            result = db.update(sql, new Object[]{getCustomer(request).get("id"), testName, testContent, testSex, testDay, testPic});
        }
        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }
    }

    @RequestMapping(value = "/testDelete")
    public ResponseEntity<String> testDelete(Model model, HttpServletRequest request, Long id, String flag) throws Exception {

        String sql = "delete from t_test where id=?";
        int result = db.update(sql, new Object[]{id});
        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }

    }

    @RequestMapping(value = "/testadd")
    public String testadd(Model model, HttpServletRequest request, Long id, String flag) throws Exception {
        if (id != null) {
            //修改
            String sql = "select * from t_test where id=?";
            Map map = db.queryForMap(sql, new Object[]{id});
            model.addAttribute("map", map);
        }
        String sql = "";
        return "/front/testadd";
    }


    ///前端增删改查例子结束/////////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = "/find")
    public String find(Model model, HttpServletRequest request)
            throws Exception {
        return "/front/find";
    }


    @RequestMapping(value = "/findSave")
    public ResponseEntity<String> findSave(Model model,
                                           HttpServletRequest request, String username, String phone)
            throws Exception {
        String sql = "select * from t_customer where username=? and phone=?";
        List<Map> list = db.queryForList(sql, new Object[]{username, phone});
        System.out.println(list);
        String result = "1";
        if (list != null && list.size() > 0) {
            Map map = list.get(0);
            return renderData(true, result, null);
        } else {
            return renderData(false, result, null);
        }

    }

    @RequestMapping(value = "/findSaveConfirm")
    public ResponseEntity<String> findSaveConfirm(Model model,
                                                  HttpServletRequest request, String username, String phone, String password)
            throws Exception {
        String sql = "update t_customer set password=? where  username=? and phone=?";
        db.update(sql, new Object[]{password, username, phone});
        return renderData(true, "", null);
    }


    @RequestMapping(value = "/lt")
    public String lt(Model model, HttpServletRequest request, String searchName, Long oneClassifyId)
            throws Exception {
        Map customer = getCustomer(request);


        String sql = "select * from t_user  ";
        sql += " order by id desc";
        List<Map> list = db.queryForList(sql);
        model.addAttribute("list", list);
        return "/front/lt";
    }

    @RequestMapping(value = "/wdxxList")
    public String wdxxList(Model model, HttpServletRequest request, String flag, String title) throws Exception {
        String sql = "select a.*,(select max(customerName) from t_customer b where a.customerId=b.id) customerName  from t_wdxx a where 1=1";

        if (1 == 1) {
            sql += " and customerId=" + getCustomer(request).get("id") + " ";
        }
        if (title != null && !"".equals(title)) {
            sql += " and title like '%" + title + "%'";
        }
        sql += " order by id desc";
        List list = db.queryForList(sql);
        request.setAttribute("list", list);
        return "/front/wdxxList";
    }

    @RequestMapping(value = "/mineaddress")
    public String mineaddress(Model model, HttpServletRequest request, String flag, String title) throws Exception {
        String sql = "select a.* from t_address a where 1=1";

        if (1 == 1) {
            sql += " and customerId=" + getCustomer(request).get("id") + " ";
        }
        sql += " order by id desc";
        List list = db.queryForList(sql);
        request.setAttribute("list", list);
        return "/front/mineaddress";
    }


    @RequestMapping(value = "/minesc")
    public String minesc(Model model, HttpServletRequest request, String flag, String title) throws Exception {
        String sql = "select (select max(productName) from t_product b where b.id=a.productId) productName,id  from t_sc a where 1=1";
        if (1 == 1) {
            sql += " and customerId=" + getCustomer(request).get("id") + " ";
        }
        sql += " order by id desc";
        List list = db.queryForList(sql);
        System.out.println(sql);
        request.setAttribute("list", list);
        return "/front/minesc";
    }

    @RequestMapping(value = "/minexiaoxi")
    public String minexiaoxi(Model model, HttpServletRequest request, String flag, String title) throws Exception {
        String sql = " select * from t_xiaoxi a where 1=1";
        if (1 == 1) {
            sql += " and customerId=" + getCustomer(request).get("id") + " ";
        }
        sql += " order by id desc";
        List list = db.queryForList(sql);
        request.setAttribute("list", list);
        return "/front/minexiaoxi";
    }

    @RequestMapping(value = "/hywdxxList")
    public String hywdxxList(Model model, HttpServletRequest request, String flag, String title) throws Exception {
        Map customer = getCustomer(request);
        String sql = "select a.*,(select max(name) from t_customer b where a.customerId=b.id) customerName  from t_wdxx a where 1=1";
        sql += " and exists(select 1 from t_wdhy b where a.customerId=b.hhId and b.customerId=" + customer.get("id") + ") ";
        if (title != null && !"".equals(title)) {
            sql += " and title like '%" + title + "%'";
        }
        sql += " order by id desc";
        List list = db.queryForList(sql);
        request.setAttribute("list", list);
        return "/front/wdxxList";
    }

    @RequestMapping(value = "/wdxxEditSave")
    public ResponseEntity<String> editSave(Model model, HttpServletRequest request, Long id, String flag
            , Integer customerId, String title, String pic, String content, Integer zan, String insertDate, String nologin, Long bkId) throws Exception {
        int result = 0;
        String sql = "insert into t_wdxx(customerId,title,pic,content,zan,insertDate,nologin,bkId,userId,status) values(?,?,?,?,?,now(),?,?,?,'待处理')";
        result = db.update(sql, new Object[]{getCustomer(request).get("id"), title, pic, content, 0, nologin, bkId, id});
        return renderData(true, "操作成功", null);
    }


    @RequestMapping(value = "/mineaddressEditSave")
    public ResponseEntity<String> mineaddressEditSave(Model model, HttpServletRequest request, Long id, String province, String city, String area, String phone, String lxr, String xxdz) throws Exception {
        int result = 0;
        if (id != null) {
            String sql = "update t_address set province=?,city=?,area=?,phone=?,lxr=?,xxdz=? where id=?";
            result = db.update(sql, new Object[]{province, city, area, phone, lxr, xxdz, id});
        } else {
            String sql = "insert into t_address(customerId,province,city,area,phone,lxr,xxdz) values(?,?,?,?,?,?,?)";
            result = db.update(sql, new Object[]{getCustomer(request).get("id"), province, city, area, phone, lxr, xxdz});
        }
        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }
    }

    @RequestMapping(value = "/wdxxEditDelete")
    public ResponseEntity<String> editDelete(Model model, HttpServletRequest request, Long id, String flag) throws Exception {

        String sql = "delete from t_wdxx where id=?";
        int result = db.update(sql, new Object[]{id});
        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }

    }

    @RequestMapping(value = "/wdxxEdit")
    public String wdxxEdit(Model model, HttpServletRequest request, Long id, String flag) throws Exception {
        Map customer = getCustomer(request);
        if (customer != null && customer.size() > 0) {
        } else {
            return "redirect:/front/login.html";
        }
        if (id != null) {
        }
        String sql = "";

        return "/front/wdxxEdit";
    }

    @RequestMapping(value = "/mineaddressEdit")
    public String mineaddressEdit(Model model, HttpServletRequest request, Long id, String flag) throws Exception {
        if (id != null) {
            //修改
            String sql = "select * from t_address where id=?";
            Map map = db.queryForMap(sql, new Object[]{id});
            model.addAttribute("map", map);
        }
        String sql = "";

        return "/front/mineaddressEdit";
    }

    @RequestMapping(value = "/wdxxShow")
    public String wdxxShow(Model model, HttpServletRequest request, Long id, String flag) throws Exception {
        String sql = "select * from t_user where id=?";
        Map map = db.queryForMap(sql, new Object[]{id});
        model.addAttribute("map", map);
        sql = "select a.*,(select max(customerName) from t_customer b where a.customerId=b.id) customerName from t_wdxx a where userId=? and status='接单' and pj is not null order by id desc";
        List<Map> list = db.queryForList(sql, new Object[]{id});
        model.addAttribute("list", list);
        return "/front/wdxxShow";
    }

    @RequestMapping(value = "/wdxxDelete")
    public ResponseEntity<String> wdxxDelete(Model model,
                                             HttpServletRequest request, Long id) throws Exception {
        Map customer = getCustomer(request);
        String sql = "delete from t_wdxx where  id=?";
        db.update(sql, new Object[]{id});
        return renderData(true, "操作成功", null);
    }

    @RequestMapping(value = "/addressDelete")
    public ResponseEntity<String> addressDelete(Model model,
                                                HttpServletRequest request, Long id) throws Exception {
        Map customer = getCustomer(request);
        String sql = "delete from t_address where  id=?";
        db.update(sql, new Object[]{id});
        return renderData(true, "操作成功", null);
    }

    @RequestMapping(value = "/pinglunSave")
    public ResponseEntity<String> pinglunSave(Model model, HttpServletRequest request, Long id, String flag
            , String wdxxId, Integer customerId, String content, String insertDate) throws Exception {
        int result = 0;
        String sql = "insert into t_pinglun(wdxxId,customerId,content,insertDate) values(?,?,?,now())";
        result = db.update(sql, new Object[]{wdxxId, getCustomer(request).get("id"), content});
        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }
    }


    @RequestMapping(value = "/productPinglunSave")
    public ResponseEntity<String> productPinglunSave(Model model, HttpServletRequest request, Long id, String flag
            , String productId, Integer customerId, String content, String insertDate) throws Exception {
        int result = 0;
        String sql = "insert into t_pinglun_product(productId,customerId,content,insertDate) values(?,?,?,now())";
        result = db.update(sql, new Object[]{productId, getCustomer(request).get("id"), content});
        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }
    }

    @RequestMapping(value = "/zanSave")
    public ResponseEntity<String> zanSave(Model model, HttpServletRequest request, Long id) throws Exception {
        int result = 0;
        String sql = "update t_wdxx set zan=zan+1 where id=?";
        result = db.update(sql, new Object[]{id});
        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }
    }


    @RequestMapping(value = "/zxList")
    public String zxList(Model model, HttpServletRequest request, String flag, String title) throws Exception {

        String sql = "select a.* from t_zx a where 1=1 ";


        if (title != null && !"".equals(title)) {
            sql += " and title like '%" + title + "%'";
        }
        sql += " order by id desc";
        List list = db.queryForList(sql);
        request.setAttribute("list", list);
        return "/front/zxList";
    }

    @RequestMapping(value = "/govzxlist")
    public String govzxlist(Model model, HttpServletRequest request, String flag, String title) throws Exception {

        String sql = "select a.* from t_govzx a where 1=1 ";
        if (title != null) {
            sql += " and title like '%" + title + "%'";
        }
        sql += " order by id desc";
        List list = db.queryForList(sql);
        request.setAttribute("list", list);
        return "/front/govzxlist";
    }

    @RequestMapping(value = "/govfvlist")
    public String govfvlist(Model model, HttpServletRequest request) throws Exception {
        return "/front/govfvlist";
    }


    @RequestMapping(value = "/zxShow")
    public String zxShow(Model model, HttpServletRequest request, Long id, String flag) throws Exception {
        String sql = "select * from t_zx where id=?";
        Map map = db.queryForMap(sql, new Object[]{id});
        model.addAttribute("map", map);
        return "/front/zxShow";
    }

    @RequestMapping(value = "/govzxShow")
    public String govzxShow(Model model, HttpServletRequest request, Long id, String flag) throws Exception {
        String sql = "select * from t_govzx where id=?";
        Map map = db.queryForMap(sql, new Object[]{id});
        model.addAttribute("map", map);
        return "/front/govzxShow";
    }
}
