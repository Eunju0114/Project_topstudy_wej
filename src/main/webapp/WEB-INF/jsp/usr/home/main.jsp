<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="메인" />
<%@ include file="../common/head.jspf"%>


<section class="section-sliders mt-2">
  <div class="con">
    <div class="slider-box-1 h-72" data-index="0">
      <div class="slides">
        <div>
          <img src="/resource/img/top/banner1.jpg" alt="슬라이더1" style="width: 1200px; height: 288px; object-fit: cover;">
        </div>
        <div>
          <img src="/resource/img/top/banner2.jpg" alt="슬라이더2" style="width: 1200px; height: 288px; object-fit: cover;">
        </div>
        <div>
          <img src="/resource/img/top/banner3.jpg" alt="슬라이더3" style="width: 1200px; height: 288px; object-fit: cover;">
        </div>
      </div>
    </div>
  </div>
</section>


<section class="section-middle mt-2">
  <div class="con flex gap-7 h-60">
    <div class="flex-1 min-w-0 b"></div>
    <div class="flex-1 min-w-0 b"></div>
    <div class="flex-1 min-w-0 flex flex-col">
      <div class="about-box flex-1 flex items-center">
        <div class="about-box__img">
          <img src="/resource/img/top/aboutUs.jpg" alt="about us" style="width:100px; height:100px; object-fit:cover;">
        </div>
        <div class="about-box-1 flex flex-col flex-1">
          <div class="about-box__head">About Us</div>
        <div class="about-box__body flex-1 flex text-center">
          <div class="flex-1"><a href="#">탑스터디</a></div>
          <div class="flex-1"><a href="#">History</a></div>
          <div class="flex-1"><a href="#">시설</a></div>
          <div class="flex-1"><a href="#">오시는 길</a></div>
        </div>
        </div>
      </div>
      <div class="number-img grid justify-items-center">
        <img src="/resource/img/top/number.png" alt="상담/문의 전화번호" />
      </div>
    </div>
  </div>

</section>
<%@ include file="../common/foot.jspf"%>