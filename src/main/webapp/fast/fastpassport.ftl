<div class="row main_block">
    <div class="col s12 block-top">
        <ul class="tabs" id="tabs">
            <li class="tab col"><a href="#block_passport" class="active" name="block_passport" data-toggle="tab">Основная
                информация</a></li>
            <li class="tab col"><a href="#block_immunization" name="block_immunization"
                                   data-toggle="tab">Иммунизация</a>
            <li class="tab col"><a href="#block_vaccination" name="block_vaccination"
                                   data-toggle="tab">Вакцинация</a></li>
            <li class="tab col"><a href="#block_quarantine" name="block_quarantine"
                                   data-toggle="tab">Карантирование</a>
            </li>
            <li class="tab col"><a href="#block_download" name="block_download" data-toggle="tab">Оригиналы</a></li>
        </ul>
    </div>
    <div class="center-block">
        <div id="block_passport" class="col s12">
        <#include "/template/input/passport.ftl">
        </div>

        <div id="block_immunization" class="col s12">
        <#include "/template/input/immunization.ftl">
        </div>

        <div id="block_vaccination" class="col s12">
        <#include "/template/input/vaccination.ftl">
        </div>

        <div id="block_quarantine" class="col s12">
        <#include "/template/input/quarantine.ftl">
        </div>

        <div id="block_download" class="col s12">
            <div id="download_file">
                <fieldset>
                    <div class="file-field input-field">
                        <div class="btn">
                            <span>Файлы</span>
                            <input type="file" name="images_p" multiple="multiple" id="images_p"/>
                        </div>
                        <div class="file-path-wrapper">
                            <input class="file-path validate" type="text" placeholder="Загрузите сканы паспорта">
                        </div>
                    </div>
                </fieldset>
                <br/>
                <div class="btn-block">
                    <a class="btn btn-primary btnPrevious">Previous</a>
                    <input class="btn btn-primary mainBtn" type="submit" value="Отправить данные">
                </div>
            </div>
        </div>
    </div>
</div>
