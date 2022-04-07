<script>

    let name = "je naam!";
    let pass = "";


    function deleteAccount(){
        if (confirm("Will je zeker je account verwijderen?")) {}
    }

    function saveAccount(){

    }


</script>


<br />

<h5>Naam</h5>

<input class="form-control" bind:value={name} />

<br />

<h5>Wachtwoord</h5>

<input class="form-control"  bind:value={pass} />


<br />

<button class="btn" id="saveButton" on:click={saveAccount}>Sla verandering <i class="fa-solid fa-check" /></button>

<button class="btn" id="deleteButton" on:click={deleteAccount}>verwijder account <i class="fa-solid fa-trash" /></button>

<style>
    #saveButton {
        background-color: rgb(127, 255, 7);
        color: white;
    }

    #deleteButton {
        background-color: rgb(255, 41, 41);
        color: white;
    }
</style>
