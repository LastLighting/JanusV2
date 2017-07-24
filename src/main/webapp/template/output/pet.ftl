<ul class="collapsible popout" data-collapsible="accordion">
    <li>
        <div class="collapsible-header">Основная информация</div>
        <div class="collapsible-body">
            <span>
            <#include "/template/output/passport.ftl">
            </span>
        </div>
    </li>
    <li>
        <div class="collapsible-header">Владелец</div>
        <div class="collapsible-body">
            <span>
            <#include "/template/output/owner.ftl">
            </span>
        </div>
    </li>
    <li>
        <div class="collapsible-header">Иммунизация</div>
        <div class="collapsible-body">
            <span>
            <#include "/template/output/immunization.ftl">
            </span>
        </div>
    </li>
    <li>
        <div class="collapsible-header">Вакцинация</div>
        <div class="collapsible-body">
            <span>
            <#include "/template/output/vaccination.ftl">
            </span>
        </div>
    </li>
    <li>
        <div class="collapsible-header">Карантин</div>
        <div class="collapsible-body">
            <span>
            <#include "/template/output/quarantine.ftl">
            </span>
        </div>
    </li>
<#--todo: Доделать оригиналы и решить как будет с bidforemployee(потому-что там уже есть вывод картинок)-->
<#--<li>-->
<#--<div class="collapsible-header">Оригиналы</div>-->
<#--<div class="collapsible-body">-->
<#--<span>-->
<#--<#include "/template/output/quarantine.ftl">-->
<#--</span>-->
<#--</div>-->
<#--</li>-->
</ul>
<script>
    $(document).ready(function(){
        $('.collapsible').collapsible();
    });
</script>