$(document).ready(function () {
    $(".phoneNumber").on("keyup", function (e) {
        e.target.value = e.target.value.replace(/[^\d]/, "");
        if (e.target.value.length === 11) {
            var ph = e.target.value.split("");
            ph.splice(3, 0, "-");
            ph.splice(7, 0, "-");
            $("label").html(ph.join(""))
        }
    });
    $('.date').each(function () {
        $(this).combodate();
    });

    $(function () {
        $('#registration')
            .validate({
                errorElement: 'div',
                highlight: function (element, errorClass, validClass) {
                    $(element).addClass(errorClass).removeClass(validClass);
                    $('.errors').find("label[for=" + element.id + "]")
                        .addClass(errorClass);
                },
                unhighlight: function (element, errorClass, validClass) {
                    $(element).removeClass(errorClass).addClass(validClass);
                    $('.errors').find("label[for=" + element.id + "]")
                        .removeClass(errorClass);
                },
                ignore: false,
                rules: {
                    documentNumber: {
                        required: true,
                        digits: true,
                        rangelength:[10,10]
                    },
                    firstName: {
                        required: true,
                        regexp: /^[а-я]+$/
                    },
                    lastName: {
                        required: true,
                        regexp: /^[а-я]+$/
                    },
                    middleName: {
                        required: true,
                        regexp: /^[а-я]+$/
                    }

                }
            });

        jQuery.extend(jQuery.validator.messages, {
            required: "Поле обязательно для заполения",
            digits: "Введите только цифры",
            regexp: "Введите только русские буквы",
            rangelength: "Серия и номер содержат 10 цифр"
        });

        $.validator.addMethod('regexp', function (value, element, params) {
            var expression = new RegExp(params);
            return this.optional(element) || expression.test(value);
        });


    });
});