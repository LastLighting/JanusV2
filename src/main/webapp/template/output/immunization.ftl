<#if immunizationList??>
<div class="row">
    <div class="input-field col s6">
        <table class="striped responsive-table">
            <thead>
            <tr>
                <th>Вид процедуры</th>
                <th>Наименование</th>
                <th>Лекарственное средство</th>
                <th>Дата приема</th>
            </tr>
            </thead>
            <tbody>
            <#--todo: Переписать на две таблы с имунизацией и паразиты-->
                <#list immunizationList as immunization>
                <tr>
                    <td>
                        <#if immunization.immunizationDeworming == true>
                            <p>Иммунизация</p>
                        <#else>
                            <p>Дегельминтизация</p>
                        </#if>
                    </td>
                    <td>
                        <div class="input-field col s12">
                            <p>${immunization.imName!""}</p>
                        </div>
                    </td>
                    <td>
                        <div class="input-field col s12">
                            <p>${immunization.drug!""}</p>
                        </div>
                    </td>
                    <td>
                        <div class="input-field col s12">
                            <p>${(immunization.date?string("dd-MM-yyyy"))!""}</p
                        </div>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>
</#if>