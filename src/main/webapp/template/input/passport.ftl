<#setting date_format="YYYY/MM/DD">
<div class="row">
    <input type="hidden" name="id" value="${passport.id}">
</div>

<div class="row">
    <div class="input-field col s6">
        <input type="text" id="petName" name="petName" value="${passport.petName!""}">
        <label for="petName">Кличка</label>
        <label for="petName" name="errors">Кличка</label>
    </div>
    <div class="input-field col s6">
        <input type="text" id="animalType" name="animalType" value="${passport.animalType!""}">
        <label for="animalType">Тип питомца</label>
    </div>
</div>

<div class="row">
    <div class="input-field col s6">
        <input type="text" id="breed" name="breed" value="${passport.breed!""}">
        <label for="breed">Порода</label>
    </div>
    <div class="input-field col s6">
        <input type="text" id="color" name="color" value="${passport.color!""}">
        <label for="color">Окрас</label>
    </div>
</div>


<div class="row">
    <div class="col s3">
        <label>Пол</label>
        <div class="switch">
            <label>
                Ж
                <input type="checkbox" id="gender" name="gender"
                       <#if passport.gender == true>checked="checked"</#if>>
                <span class="lever"></span>
                М
            </label>
        </div>
    </div>
    <div class="col s3">
        <label>Идентификация</label>
        <div class="switch">
            <label>
                Чип
                <input type="checkbox" id="microchipTattoo" name="microchipTattoo"
                       <#if passport.microchipTattoo == true>checked="checked"</#if>>
                <span class="lever"></span>
                Тату
            </label>
        </div>
    </div>
    <div class="input-field col s6">
        <input type="text" class="date" id="dateOfImplantation"
               name="dateOfImplantation" data-format="YYYY/MM/DD" data-template="D MMM YYYY"
               value="${passport.dateOfImplantation!"1996/10/24"?date}">
        <label for="dateOfImplantation">Дата татуирования/чипирования</label>
    </div>
    <div class="input-field col s3">
        <input type="checkbox" id="castrationSterilization" name="castrationSterilization"
               <#if passport.castrationSterilization == true>checked="checked"</#if>>
        <label for="castrationSterilization">Кастрация/Стерилизация</label>
    </div>
</div>

<div class="row microchipTattooShower">
    <div class="input-field col s6">
        <input type="text" id="numberMicrochipTattoo" name="numberMicrochipTattoo"
               value="${passport.numberMicrochipTattoo!""}">
        <label for="numberMicrochipTattoo">Номер чипа/тату</label>
    </div>
    <div class="input-field col s6">
        <input type="text" class="date" id="dateOfBirth"
               name="dateOfBirth" data-format="YYYY/MM/DD" data-template="D MMM YYYY"
               value="${passport.dateOfBirth!"1996/10/24"?date}">
        <label for="dateOfBirth">Дата рождения</label>
    </div>
</div>

<div class="row">
    <div class="input-field col s6">
        <input type="text" id="clinic" name="clinic" value="${passport.clinic!""}">
        <label for="clinic">Клиника</label>
    </div>
    <div class="input-field col s6">
        <input type="text" id="doctor" name="doctor" value="${passport.doctor!""}">
        <label for="doctor">Доктор</label>
    </div>
</div>

<div class="row">
    <div class="input-field col s12">
        <input type="text" id="offspring" name="offspring" value="${passport.offspring!""}"
               class="validate">
        <label for="offspring">Потомство</label>
    </div>
</div>

<div class="row">
    <div class="input-field col s12">
                    <textarea id="specialFeatures" name="specialFeatures"
                              class="materialize-textarea">${passport.specialFeatures!""}</textarea>
        <label for="specialFeatures">Специальные признаки</label>
    </div>
</div>
<a class="btn btn-primary btnNext">Next</a>