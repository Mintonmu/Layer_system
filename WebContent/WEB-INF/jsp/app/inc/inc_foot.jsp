<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script>
	var ctx = '${ctx}';
</script>
<!-- Page Footer-->
<div class="footer">
    <div class="footer-socials half-bottom">
    	<%--
        <a href="#" class="footer-facebook"></a>
        <a href="#" class="footer-twitter"></a>
        <a href="#" class="footer-google"></a>
        <a href="#" class="footer-share show-share-bottom"></a> --%>
        <a href="#" class="footer-up"><i class="fa fa-angle-up"></i></a>
    </div>
    <p class="center-text">Copyright 2015. All rights reserved.</p>
</div>

<!-- Share Elements-->
<div class="share-bottom">
    <h3>Share Page</h3>
    <div class="share-socials-bottom">
        <a href="http://sc.chinaz.com/">
            <i class="fa fa-facebook facebook-color"></i>
            Facebook
        </a>
        <a href="http://sc.chinaz.com/">
            <i class="fa fa-twitter twitter-color"></i>
            Twitter
        </a>
        <a href="http://sc.chinaz.com/">
            <i class="fa fa-google-plus google-color"></i>
            Google
        </a>

        <a href="http://sc.chinaz.com/">
            <i class="fa fa-pinterest-p pinterest-color"></i>
            Pinterest
        </a>
        <a href="sms:">
            <i class="fa fa-comment-o sms-color"></i>
            Text
        </a>
        <a href="http://sc.chinaz.com/">
            <i class="fa fa-envelope-o mail-color"></i>
            Email
        </a>
    </div>
    <a href="#" class="close-share-bottom">Close</a>
</div>    
<div class="menu-wrapper-background"></div>