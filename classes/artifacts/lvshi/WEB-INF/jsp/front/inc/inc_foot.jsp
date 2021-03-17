<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
    var ctx = '${ctx}';
</script>
<footer>

    <div class="container">
        <div class="wrap-footer">
            <div class="row">
                <div class="col-md-3 col-footer footer-1">
                    <img src="${ctx}/resource/front4/images/logo.png"/>
                    <p>本系统是本人第一个律师咨询事务所系统，功能涵盖全面，由本人亲自完成所有的功能，目前已经完成所有，结束这个毕业设计</p>
                </div>
                <div class="col-md-3 col-footer footer-2">
                    <div class="heading"><h4>Customer Service</h4></div>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Delivery Information</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms & Conditions</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>
                <div class="col-md-3 col-footer footer-3">
                    <div class="heading"><h4>核心价值观</h4></div>
                    <ul>
                        <li><a href="#">客户至上</a></li>
                        <li><a href="#">精诚奉献</a></li>
                        <li><a href="#">协同共享</a></li>
                        <li><a href="#">团队合作</a></li>
                        <li><a href="#">追求卓越</a></li>
                    </ul>
                </div>
                <div class="col-md-3 col-footer footer-4">
                    <div class="heading"><h4>Contact Us</h4></div>
                    <ul>
                        <li><span class="glyphicon glyphicon-home"></span>我们：法律咨询管理系统</li>
                        <li><span class="glyphicon glyphicon-earphone"></span>+6221 888 888 90 , +6221 888 88891</li>
                        <li><span class="glyphicon glyphicon-envelope"></span>infor@yoursite.com</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="copyright">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    Copyright &copy; 2019.Company name All rights reserved.
                </div>
                <div class="col-md-6">
                    <div class="pull-right">
                        <ul>
                            <li><img src="${ctx}/resource/front4/images/visa-curved-32px.png"/></li>
                            <li><img src="${ctx}/resource/front4/images/paypal-curved-32px.png"/></li>
                            <li><img src="${ctx}/resource/front4/images/discover-curved-32px.png"/></li>
                            <li><img src="${ctx}/resource/front4/images/maestro-curved-32px.png"/></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>

