<#if vaccinationList??>
<div class="row">
    <div class="input-field col s6">
        <table class="striped responsive-table">
            <thead>
            <tr>
                <th>Серия вакцины</th>
                <th>Тип вакцины</th>
                <th>Дата вакцинации</th>
                <th>Действительна до</th>
            </tr>
            </thead>
            <tbody>
                <#list vaccinationList as vaccination>
                <tr>
                    <td>
                        <p>${vaccination.seriesOfVaccine!""}</p>
                    </td>
                    <td>
                        <p>${vaccination.typeOfVaccine!""}</p>
                    </td>
                    <td>
                        <p>${(vaccination.dateOfVaccine?string("dd/MM/yyyy"))!""}</p>
                    </td>
                    <td>
                        <p>${(vaccination.validUntil?string("dd/MM/yyyy"))!""}</p>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>
</#if>



<#--<#list vaccinationList as vaccination>-->
<#--<div class="row">-->
    <#--<div class="col s12">-->
        <#--<input type="hidden" name="id" value="${vaccination.id}">-->
    <#--</div>-->
<#--</div>-->


<#--<div class="row">-->
    <#--<div class="input-field col s12">-->
        <#--<label>Серия вакцины</label>-->
        <#--<p>${vaccination.seriesOfVaccine!""}</p>-->
    <#--</div>-->
<#--</div>-->

<#--<div class="row">-->
    <#--<div class="input-field col s4">-->
        <#--<label>Тип вакцины</label>-->
        <#--<p>${vaccination.typeOfVaccine!""}</p>-->
    <#--</div>-->
    <#--<div class="input-field col s4">-->
        <#--<label>Дата вакцинации</label>-->
        <#--<p>${(vaccination.dateOfVaccine?string("dd/MM/yyyy"))!""}</p>-->
    <#--</div>-->
    <#--<div class="input-field col s4">-->
        <#--<label>Действительна до</label>-->
        <#--<p>${(vaccination.validUntil?string("dd/MM/yyyy"))!""}</p>-->
    <#--</div>-->
<#--</div>-->
<#--</#list>-->