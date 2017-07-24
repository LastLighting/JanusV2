<#if petList??>
<table class="striped responsive-table">
    <thead>
    <tr>
        <th>Кличка</th>
        <th>Тип питомца</th>
        <th>Порода</th>
        <th>Окрас</th>
        <th>Пол</th>
        <th>Дата рождения</th>
        <th>Номер чипа/тату</th>
    </tr>
    </thead>
    <tbody>
        <#list petList as pet>
        <tr>
            <td><p>${pet.passport.petName!""}</p></td>
            <td><p>${pet.passport.animalType!""}</p></td>
            <td><p>${pet.passport.breed!""}</p></td>
            <td><p>${pet.passport.color!""}</p></td>
            <td>
                <#if pet.passport.gender == true>
                    <p>Ж</p>
                <#else>
                    <p>М</p>
                </#if>
            </td>
            <td><p>${(pet.passport.dateOfBirth?string("dd-MM-yyyy"))!""}</p></td>
            <td><p>${pet.passport.numberMicrochipTattoo!""}</p></td>
        </tr>
        </#list>
    </tbody>
</table>
</#if>