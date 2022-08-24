<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="메인" />
<%@ include file="../common/head.jspf" %>


<section class="section-sliders mt-1">
  <div class="con px-3">
    <div class="slider-box-1 h-80" data-index="0">
      <div class="slides">
        <div><img src="/resource/img/top/banner1.jpg" alt="슬라이더1" style="width: 1500px; height:320px; object-fit:cover;"></div>
        <div><img src="/resource/img/top/banner2.jpg" alt="슬라이더2" style="width: 1500px; height:320px; object-fit:cover;"></div>
        <div><img src="/resource/img/top/banner3.jpg" alt="슬라이더3" style="width: 1500px; height:320px; object-fit:cover;"></div>
      </div>
    </div>
  </div>
</section>

<%@ include file="../common/foot.jspf" %>