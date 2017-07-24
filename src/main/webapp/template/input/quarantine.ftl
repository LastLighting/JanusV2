<div class="row">
 <#--   <input type="hidden" id="quarantine.id" name="id" value="${quarantine.id!0}">-->
    <div class="input-field col s6">
        <input type="text" id="laboratory" name="laboratory" value="${quarantine.laboratory!""}">
        <label for="quarantine.laboratory">Лаборатория</label>
    </div>
    <div class="input-field col s6">
        <input type="text" id="addressOfLaboratory" name="addressOfLaboratory"
               value="${quarantine.addressOfLaboratory!""}">
        <label for="quarantine.addressOfLaboratory">Адрес лабораторной</label>
    </div>
    <div class="input-field col s4">
        <input type="text" id="numberOfDays" name="numberOfDays"
               value="${quarantine.numberOfDays!0}">
        <label for="numberOfDays">Дней в карантине</label>
    </div>
</div>
<#list quarantine.diseases as item>
<fieldset class="template-block" idquarantine="${item_index}">
    <div class="row">
        <div class="input-field col s6">
            <input type="text" id="diseases[${item_index}].disName" name="diseases[${item_index}].disName"
                   value="${item.disName!""}">
            <label for="diseases[${item_index}].disName">Наименование</label>
        </div>
        <div class="input-field col s6">
            <input type="text" id="diseases[${item_index}].researchMethod" name="diseases[${item_index}].researchMethod"
                   value="${item.researchMethod!""}">
            <label for="diseases[${item_index}].researchMethod">Метод исследования</label>
        </div>
    </div>
    <div class="row">
        <div class="input-field col s5">
            <input type="text" id="diseases[${item_index}.result" name="diseases[${item_index}].result"
                   value="${item.result!""}">
            <label for="diseases[${item_index}].result">Результат</label>
        </div>
        <div class="input-field col s5">
            <input type="text" class="date" id="diseases[${item_index}].dateResearch"
                   name="diseases[${item_index}].dateResearch" data-format="YYYY/MM/DD" data-template="D MMM YYYY"
                   value="${item.dateResearch!"1996/10/24"?date}">
        </div>
    </div>
    <div class="col s4">
        <a class="btn btn-primary btnAddQuar">Добавить</a>
    </div>
</fieldset>
<fieldset class="template-block hide" id="quarantineTemplate">
    <div class="row">
        <div class="input-field col s6">
            <input type="text" id="diseases.disName" name="diseases.disName">
            <label for="diseases[${item_index}].disName">Наименование</label>
        </div>
        <div class="input-field col s6">
            <input type="text" id="diseases.researchMethod" name="diseases.researchMethod">
            <label for="diseases[${item_index}].researchMethod">Метод исследования</label>
        </div>
    </div>
    <div class="row">
        <div class="input-field col s5">
            <input type="text" id="diseases.result" name="diseases.result">
            <label for="diseases[${item_index}].result">Результат</label>
        </div>
        <div class="input-field col s5">
            <input type="text" class="date" id="diseases.dateResearch" name="diseases.dateResearch"
                   data-format="YYYY/MM/DD" data-template="D MMM YYYY" value="${item.dateResearch!"1996/10/24"?date}">
            <label for="diseases[${item_index}].dateResearch">Дата исследования</label>
        </div>
    </div>
    <div class="col s4">
        <a class="btn btn-primary btnRemoveQuar">Удалить</a>
    </div>
</fieldset>
</#list>
<div class="btn-block">
    <a class="btn btn-primary btnPrevious">Previous</a>
    <a class="btn btn-primary btnNext">Next</a>
</div>
