$(document).ready(function () {

    $('.date').each(function () {
        $(this).combodate();
    });

    //динамическое добавление specialNotes
    var numberRowNotes = $('fieldset[idnotes]:last').attr('idnotes');
    $('#block_specnotes').on('click', '.btnAddNotes', function () {
        numberRowNotes++;
        var $template = $('#notesTemplate'),
            $clone = $template
                .clone()
                .removeClass('hide')
                .removeAttr('id')
                .attr('idnotes', numberRowNotes)
                .insertBefore($template);
        $clone
            .find('[name="specialNotes.specialConditionsCarriage"]').attr('name', 'specialNotes[' + numberRowNotes + '].specialConditionsCarriage').attr('id', 'specialNotes[' + numberRowNotes + '].specialConditionsCarriage').end()
            .find('[name="specialNotes.inspectionNotes"]').attr('name', 'specialNotes[' + numberRowNotes + '].inspectionNotes').attr('id', 'specialNotes[' + numberRowNotes + '].inspectionNotes').end()
            .find('[name="specialNotes.dateNotes"]').attr('name', 'specialNotes[' + numberRowNotes + '].dateNotes').attr('id', 'specialNotes[' + numberRowNotes + '].dateNotes').end()

    })
        .on('click', '.btnRemoveNotes', function () {
            var $row = $(this).parents('.template-block');
            $row.remove();
        });






});
