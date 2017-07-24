<div class="row main_block">
    <div class="col s12 block-top">
        <ul class="tabs">
            <li class="tab col"><a class="active" href="#block_bid">Основная информация</a></li>
        <#--<#list petList as pet>-->
        <#--<li class="tab col"><a href="#block_pet${pet_index}">Питомец ${pet_index+1}</a></li>-->
        <#--</#list>-->

        </ul>
    </div>
    <div id="block_bid" class="col s12">
        <div class="center-block">
            <div class="row">
                <form name="form1" method="POST">
                    <div class="col s10">
                        <select name="status" id="status" required>
                            <option value="ACCEPTED">Принять</option>
                            <option value="REJECTED">Отклонить</option>
                        </select>
                    </div>
                    <div class="col s2">
                        <input type="submit" name="send" value="Сохранить">
                    </div>
                </form>
            </div>
        <#include "/template/output/bid.ftl">
        <#include "/template/output/route.ftl">
        </div>
    </div>

<#list petList as pet>
    <div id="block_pet${pet_index}" class="col s12">
        <div class="row center-block">
        <#--<div class="col s4">-->
        <#--<ul class="pgwSlider">-->
        <#--<#list pet.passport.images.path as path>-->
        <#--<li><img src="${path}" alt=""></li>-->
        <#--</#list>-->
        <#--</ul>-->
        <#--</div>-->
            <div class="col s8">
                <#assign passport = pet.passport/>
                    <#assign passport = pet.passport.owner/>
                    <#--<#assign passport = pet.passport/>-->
                    <#include "/template/output/pet.ftl">
            </div>
        </div>
    </div>
</#list>
</div>
