
            <div class="row">
                <div class="col s12">
                    <input type="text" name="numberAndSeriesOfPassport" value="${owner.numberAndSeriesOfPassport}">
                </div>
                <div class="input-field col s6">
                    <input type="text" id="firstName" name="firstName" value="${owner.firstName!}" class="validate">
                    <label for="firstName">firstName</label>
                </div>
                <div class="input-field col s6">
                    <input type="text" id="lastName" name="lastName" value="${owner.lastName!}" class="validate">
                    <label for="lastName">lastName</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input type="text" id="middleName" name="middleName" value="${owner.middleName!}" class="validate">
                    <label for="patronymic">patronymic</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input type="text" id="dateOfBirth" name="dateOfBirth" value="${owner.dateOfBirth?string("dd/MM/yyyy")}" class="validate">
                    <label for="dateOfBirth">dateOfBirth</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input type="text" id="phoneNumber" name="phoneNumber" value="${owner.phoneNumber!""}" class="validate">
                    <label for="phoneNumber">phoneNumber</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input type="text" id="address" name="address" value="${owner.address!""}" class="validate">
                    <label for="address">address</label>
                </div>
