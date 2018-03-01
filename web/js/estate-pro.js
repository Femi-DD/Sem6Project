$(document).ready(function(){
// use jQuery correctly with strict
    (function($) {
        "use strict";
        // your code
        
    /* ----------------------------------------
    Google Map - Info Window Style
    ---------------------------------------- */
        $('.gm-style-iw').parent().addClass('google_map_info_contents');
        
    /*------------------------------    
    Currency Filter
    ------------------------------*/
        $('.dropdownFilters .dropdown-menu').find('a').click(function(e) {
            e.preventDefault();
            var param = $(this).attr("href").replace("#","");
            var concept = $(this).find('span').text();
            $('.dropdownFilters span#filterValue').text(concept)
            //$('.input-group #search_param').val(param)
        });
    /*------------------------------    
    Go Top
    ------------------------------*/
        $('a[href="#top"]').click(function () {
            $('html, body').animate({ scrollTop: 0 }, 800);
            return false
        });      
    /*------------------------------    
    Currency Filter
    ------------------------------*/
        $('.languageFilters .dropdown-menu').find('a').click(function(e) {
            e.preventDefault();
            var param = $(this).attr("href").replace("#","");
            var concept = $(this).find('span').text();
            $('.languageFilters span#filterValue2').text(concept)
            //$('.input-group #search_param').val(param)
        });
        
    /*----------------------------------------------------*/
    /*  Spinner
    /*----------------------------------------------------*/
        $('.spinner .btn:first-of-type').on('click', function() {
            $('.spinner input').val( parseInt($('.spinner input').val(), 10) + 1);
        });
        $('.spinner .btn:last-of-type').on('click', function() {
            $('.spinner input').val( parseInt($('.spinner input').val(), 10) - 1);
        });
        
    /*----------------------------------------------------*/
    /*  Phone Number Show
    /*----------------------------------------------------*/
        $('.phone_trigger').on('click', function() {
            $(this).toggleClass('active');
            $(this).parent().parent().find('.phoneNumber').toggleClass('active');
        });
        
    /*----------------------------------------------------*/
    /*  Owl Carousels
    /*----------------------------------------------------*/
        $('.agents_carousel,.partners_carousel').owlCarousel({
            loop:true,
            responsiveClass:true,
            dots:false,
            nav:true,
            navText:['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
            responsive:{
                0:{
                    items:1,
                    nav:true
                },
                768:{
                    items:2,
                    nav:false
                },
                992:{
                    items:3,
                    nav:false
                },
                1200:{
                    items:4,
                    nav:true,
                    loop:false
                }
            }
        });
        
    /*----------------------------------------------------*/
    /*  Owl Carousels
    /*----------------------------------------------------*/
        $('.testimonial_carousel').owlCarousel({
            loop:true,
            responsiveClass:true,
            dots:true,
            nav:false, 
            items:1
        });
        
        
    /*----------------------------------------------------*/
    /*  Additional Details
    /*----------------------------------------------------*/        
        $('.add_new_field').on('click',function(){
            $('.additional_details').append(
                '<div class="row m0 alert" role="alert">'+
                    '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>'+
                    '<div class="fleft title_box form-group">'+
                        '<label for="">Title</label>'+
                        '<input type="text" class="form-control" name="" id="">'+
                    '</div>'+
                    '<div class="fleft value_box form-group">'+
                        '<label for="">Value</label>'+
                        '<input type="text" class="form-control" name="" id="">'+
                    '</div>'+
                '</div>'
            )
        });
        
        
    /*----------------------------------------------------*/
    /* User Form Select
    /*----------------------------------------------------*/        
        $('input#user_type').on('click',function() { 
            if ($(this).is(':checked')) {
                $('.new_user_form').addClass('hide');
                $('.new_user_form').removeClass('show');
                $('.existing_user_form').addClass('show');
                $('.existing_user_form').removeClass('hide')
            } else {
                $('.new_user_form').addClass('show');
                $('.new_user_form').removeClass('hide');
                $('.existing_user_form').addClass('hide');
                $('.existing_user_form').removeClass('show')
            }
        })
        
    
        
    })(jQuery)
});

$(window).load(function() {        
// use jQuery correctly with strict
    (function($) {
        "use strict";
        // your code
        
    /*------------------------------    
    Main Slider
    ------------------------------*/
    $('#mainSlider').flexslider({
        animation: "fade",
        controlNav: false,
        directionNav: true,
        prevText: '<i class="fa fa-angle-left"></i>',
        nextText: '<i class="fa fa-angle-right"></i>', 
    });    
    $('#mainSlider').find('.flex-direction-nav').addClass('container')
    
    
    })(jQuery)
})