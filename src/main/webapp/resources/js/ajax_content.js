/**
 * Created by Татьяна on 09.06.2017.
 */

// $(document).ready(function(){
//     $('#getPassport').click(function(){
//         $.ajax({
//             url: "/passport/passport.ftl",
//             cache: false,
//             beforeSend: function() {
//                 $('#divPassport').html('Получаем контент');
//             },
//             success: function(html){
//                 $("#divPassport").html(html);
//             }
//         });
//         return false;
//     });
// });

$(document).ready(function() {
    $('.fastPassportMenu a').click(function() {
        var h = $(this).attr('href');
        alert(h);
        $.ajax({
            url: h,
            cache: false,
            beforeSend: function() {
                $('#fastPassportMenuLoader').html(h);
            },
            success: function(html){
                $("#fastPassportMenuLoader").html(html);

            }
        });
        return false;
    });
});

