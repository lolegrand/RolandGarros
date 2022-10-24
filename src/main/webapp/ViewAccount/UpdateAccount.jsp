<article class="w-50 row space-around">

    <form class="w-100 row" name="FormUpdateAccount">

        <label class="w-50">Login</label>
        <input class="w-50" readonly value="${account.getLogin()}">

        <label class="w-50">Password</label>
        <input class="w-50" type="password" name="newPwd" placeholder="Password">

        <input class="w-25" type="submit" name="submitFormUpdateAccount" value="Mettre à Jour">

    </form>

</article>