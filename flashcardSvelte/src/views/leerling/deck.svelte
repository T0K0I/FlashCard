<script>
  export let id;
  export let name = "een naam";

	import { createEventDispatcher } from 'svelte';
  const dispatch = createEventDispatcher();

  let editMode = false;

  function submitChangesByEnter(event) {if (IS_ENTER_PRESSED(event)) {submitChanges();}}

  function submitChanges(){toggleEditMode();}

  function toggleEditMode() {if (editMode) {editMode = false;} else {editMode = true;}}

  function deleteMe(){if (confirm("Will je zeker het kaart " + name + " will verwijderen?")) {}}

  function enterDeck(){dispatch('message', {type: 'enter_deck',ID_of_deck: id});}

</script>

<div class="card shadow mb-4">
  <div class="card-header py-3" style="display: flex;">
    {#if editMode === false}
      <h6 class="m-0 font-weight-bold text-primary">{name}</h6>
    {:else}
      <input class="form-control" on:keydown={submitChangesByEnter} bind:value={name} />

      <button class="btn" on:click={submitChanges}><i class="fa-solid fa-check"></i></button>
    {/if}
  </div>
  <br />
  <div class="buttonholder">
    {#if editMode === false}
      <button class="btn" on:click={enterDeck}><i class="fa-solid fa-hand"/></button>
      <button class="btn" on:click={toggleEditMode}><i class="fa-solid fa-pen"/></button>
      <button class="btn" on:click={deleteMe}><i class="fa-solid fa-trash"/></button>
    {/if}
  </div>
</div>
