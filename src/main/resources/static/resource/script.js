console.clear();

let i = 0;

setInterval(function(){
  $('.slider-box-1').attr('data-index', ++i % 3);
}, 3000);