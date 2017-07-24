<#if quarantine??>
<div class="row">
    <input type="hidden" name="id" value="${quarantine.id!0}">
    <div class="input-field col s8">
        <label>Лаборатория</label>
        <br/>
        <p>${quarantine.laboratory!""}</p>
    </div>
    <div class="input-field col s4">
        <label>Дней в карантине</label>
        <br/>
        <p>${quarantine.numberOfDays!0}</p>
    </div>
</div>

<div class="row">
    <div class="input-field col s12">
        <label>Адрес лаборатории</label>
        <br/>
        <p>${quarantine.addressOfLaboratory!""}</p>
    </div>
</div>

<div class="row">
    <table class="striped responsive-table">
        <thead>
        <tr>
            <th>Название заболевания</th>
            <th>Дата исследования</th>
            <th>Метод исследования</th>
            <th>Результат</th>
        </tr>
        </thead>
        <tbody>
            <#list quarantine.diseases as diseases>
            <tr>
                <td>${diseases.disName}</td>
                <td>${diseases.dateResearch}</td>
                <td>${diseases.researchMethod}</td>
                <td>${diseases.result}</td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</#if>



