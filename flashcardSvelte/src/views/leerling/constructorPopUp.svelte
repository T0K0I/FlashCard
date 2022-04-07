<script>

    let name = "";
    let descriptie = "";

    export let mode = 0;

    //mode 0 is deck
    //mode 1 is card
    //mode 2 is tag

    function submitChangesByEnter(event) {if (IS_ENTER_PRESSED(event)) {submitChanges();}}

    export let submitChanges;

</script>

<div id="popupCons" class="card">

    <button on:click={submitChanges} class="btn">sluit <i class="fa-solid fa-xmark"></i></button>

    <h4>Naam</h4>
    <input
        class="form-control"
        on:keydown={submitChangesByEnter}
        bind:value={name}
    />

    {#if mode === 1}
        <h4>Descriptie</h4>
        <input
            class="form-control"
            on:keydown={submitChangesByEnter}
            bind:value={descriptie}
        />
    {/if}

    <button class="btn" on:click={submitChanges}
    >voeg toe<i class="fa-solid fa-plus" style="margin-left: 5px;"/></button>
</div>

<style>
    #popupCons {
        position: fixed;
        width: 300px;
        z-index: 1;
        box-shadow: 0px 2px 15px black;
    }
</style>
