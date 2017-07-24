$(document).ready(function () {

    $('.date').each(function () {
        $(this).combodate();
    });

    $('select').material_select();

    $('ul.tabs').tabs();

    $isValid = false;
    var numberRowQuar = $('fieldset[idquarantine]:last').attr('idquarantine');
    $('#block_quarantine').on('click', '.btnAddQuar', function () {
        numberRowQuar++;
        var $template = $('#quarantineTemplate'),
            $clone = $template
                .clone()
                .removeClass('hide')
                .removeAttr('id')
                .attr('idquarantine', numberRowQuar)
                .insertBefore($template);
        $clone
            .find('[name="diseases.disName"]').attr('name', 'diseases[' + numberRowQuar + '].disName').attr('id', 'diseases[' + numberRowQuar + '].disName').end()
            .find('[name="diseases.researchMethod"]').attr('name', 'diseases[' + numberRowQuar + '].researchMethod').attr('id', 'diseases[' + numberRowQuar + '].researchMethod').end()
            .find('[name="diseases.result"]').attr('name', 'diseases[' + numberRowQuar + '].result').attr('id', 'diseases[' + numberRowQuar + '].result').end()
            .find('[name="diseases.dateResearch"]').attr('name', 'diseases[' + numberRowQuar + '].dateResearch').attr('id', 'diseases[' + numberRowQuar + '].dateResearch').end();

    })
        .on('click', '.btnRemoveQuar', function () {
            var $row = $(this).parents('.template-block');
            $row.remove();
        });

    // Динамические поля для вакцинации
    var numberRowVaccination = $('fieldset[idvac]:last').attr('idvac');
    $('#block_vaccination').on('click', '.btnAddVac', function () {

        numberRowVaccination++;
        var $templateVaccination = $('#templateVaccination'),
            $vac_clone = $templateVaccination
                .clone()
                .removeClass('hide')
                .removeAttr('id')
                .attr('idvac', numberRowVaccination)
                .insertBefore($templateVaccination);
        $vac_clone
            .find('[name="vaccination.seriesOfVaccine"]').attr('name', 'vaccination[' + numberRowVaccination + '].seriesOfVaccine').attr('id', 'vaccination[' + numberRowVaccination + '].seriesOfVaccine').end()
            .find('[name="vaccination.typeOfVaccine"]').attr('name', 'vaccination[' + numberRowVaccination + '].typeOfVaccine').attr('id', 'vaccination[' + numberRowVaccination + '].typeOfVaccine').end()
            .find('[name="vaccination.dateOfVaccine"]').attr('name', 'vaccination[' + numberRowVaccination + '].dateOfVaccine').attr('id', 'vaccination[' + numberRowVaccination + '].dateOfVaccine').end()
            .find('[name="vaccination.validUntil"]').attr('name', 'vaccination[' + numberRowVaccination + '].validUntil').attr('id', 'vaccination[' + numberRowVaccination + '].validUntil').end()
    })
        .on('click', '.btnRemoveVac', function () {
            var $row = $(this).parents('.template-block');
            $row.remove();
        });

    // Динамические поля для иммунизации
    var numberRowImmunization = 0;
    $('#block_immunization').on('click', '.btnAddImmun', function () {
        numberRowImmunization++;
        var $templateImmun = $('#immunTemplate'),
            $vac_clone = $templateImmun
                .clone()
                .removeClass('hide')
                .removeAttr('id')
                .attr('idimmun', numberRowImmunization)
                .insertBefore($templateImmun);

        $vac_clone
            .find('[name="immunizationDeworming"]').attr('id', 'passport.immunizationDeworming[' + numberRowImmunization + '].immunizationDeworming').attr('name', 'immunizationDeworming[' + numberRowImmunization + '].immunizationDeworming').end()
            .find('[name="imName"]').attr('id', 'passport.immunizationDeworming[' + numberRowImmunization + '].imName').attr('name', 'immunizationDeworming[' + numberRowImmunization + '].imName').end()
            .find('[name="drug"]').attr('id', 'passport.immunizationDeworming[' + numberRowImmunization + '].drug').attr('name', 'immunizationDeworming[' + numberRowImmunization + '].drug').end()
            .find('[name="immunizationDeworming.date"]').attr('id', 'passport.immunizationDeworming[' + numberRowImmunization + '].date').attr('name', 'immunizationDeworming[' + numberRowImmunization + '].date').end()
    })
        .on('click', '.btnRemoveImmun', function () {
            var $row = $(this).parents('.template-block');
            $row.remove();
        });

    $('.btnNext').on('click', function () {
        $isValid = false;
        var name = $('#tabs').find('.active').parent().next().children().attr('name');
        $('ul.tabs').tabs('select_tab', name);
    });

    $('.btnPrevious').on('click', function () {
        var name = $('#tabs').find('.active').parent().prev().children().attr('name');
        $('ul.tabs').tabs('select_tab', name);

    });


});


$(function () {
    $('#form1')
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
                images_p: {
                    required: true,
                    extension: 'jpe?g,png',
                    accept: 'jpe?g,png',
                    uploadFile: true
                },
                photo: {
                    required: true,
                    extension: 'jpe?g,png',
                    uploadFile: true
                },
                petName: {
                    required: true,
                    regexp: /^[а-я]+$/
                },
                animalType: {
                    required: true,
                    regexp: /^[а-я]+$/
                },
                breed: {
                    required: true,
                    regexp: /^[а-я]+$/
                },
                color: {
                    required: true,
                    regexp: /^[а-я]+$/
                },
                doctor: {
                    required: true,
                    regexp: /^[а-я]+$/
                },
                numberMicrochipTattoo: {
                    required: true,
                    digits: true
                },
                clinic: {
                    required: true
                }

            }
        });


   /* $('[id^="vaccination["]').rules("add",{
            required: true,
            regexp: /^[а-я]+$/
        });*/

    jQuery.extend(jQuery.validator.messages, {
        required: "Поле обязательно для заполения",
        digits: "Введите только цифры",
        regexp: "Введите только русские буквы"
    });

    $.validator.addMethod('regexp', function (value, element, params) {
        var expression = new RegExp(params);
        return this.optional(element) || expression.test(value);
    });


});
