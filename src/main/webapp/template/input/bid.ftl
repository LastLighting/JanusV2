<script type="text/javascript" rel="script" src="/resources/js/combodate.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/moment.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/moment.js"></script>
<link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
<script>
    $(document).ready(function () {
        $('.date').each(function () {
            $(this).combodate();
            $('select').material_select();
        });
    });
</script>
<div class="row">
    <div class="col s6">
        <label for="countPet">Количество питомцев</label>
        <input type="text" name="countPet" id="countPet" value="${bid.countPet!0}" required autofocus/>
    </div>
    <div class="col s6">
        <label for="countSeats">Количество мест под питомцев</label>
        <input type="text" name="countSeats" id="countSeats" value="${bid.countSeats!0}" required/>
    </div>
</div>
<div>
    <div class="row">
        <div class="input-field col s6">
        <#setting date_format="YYYY/MM/DD">
            <input type="text" class="date" id="departureDate"
                   name="departureDate" data-format="YYYY/MM/DD" data-template="D MMM YYYY"
                   value="${bid.departureDate!"1996/10/24"?date}">
            <label for="departureDate">Дата поездки</label>
        </div>
   <div class="input-field col s8">
            <select id="petsid[]" name="petsid[]" multiple>
                   <#list petList as pet>
                         <option value="${pet.id}">${pet.passport.petName!""}</option>
                   </#list>
            </select>
            <label for="pet">Питомцы</label>
        </div>
    </div>
</div>