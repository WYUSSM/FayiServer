/*手机端手指滑动*/
$(document).ready(function(){
  
                var startX,endX;//声明触摸的两个变量  
                var offset = 30;//声明触摸距离的变量  
                $('.carousel-inner').on('touchstart',function (e) {  
                    startX= e.originalEvent.touches[0].clientX;//当触摸开始时的x坐标；  
                });  
                $('.carousel-inner').on('touchmove',function (e) {  
                    endX = e.originalEvent.touches[0].clientX;//当触摸离开时的x坐标；  
                });  
                $('.carousel-inner').on('touchend',function (e) {  
                    //当触摸完成时进行的事件；  
                    var distance = Math.abs(startX - endX);//不论正负，取值为正值；  
                    if (distance > offset){  
                        if(startX > endX){  
                            $('#myCarousel').carousel('next');//当开始的坐标大于结束的坐标时，滑动到下一附图  
                        }else{  
                            $('#myCarousel').carousel('prev');//当开始的坐标小于结束的坐标时，滑动到上一附图  
  
                        }  
                                  
                    }  
                });   
            }); 
