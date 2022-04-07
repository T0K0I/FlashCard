<script>
  let title = "deck";

  import Card from "./card.svelte";

  import Deck from "./deck.svelte";

  import ConstructorPopUp from "./constructorPopUp.svelte";

  let showConstructor = false;

  function startConstruction(){showConstructor = true;}

</script>

<div id="stickyDivie">
  <button class="btn" id="createCardBtn" on:click={startConstruction}
    >Maak {title}<i class="fa-solid fa-plus" /></button>
  <button class="btn" id="startSessionButton"
    >Start sessie<i class="fa-solid fa-play" /></button>
</div>
<br />


{#if showConstructor}
  <ConstructorPopUp submitChanges={() => showConstructor = false}/>
{/if}

<div class="row">
  <div class="col-lg-6">
    <Deck />
    <Card />
    <Card />
    <Card />
    <Card />
  </div>

  <div class="col-lg-6">
      <Card />
      <Card />
      <Card />
      <Card />
      <Card />
  </div>
</div>

<style>
  #stickyDivie i {
    margin-left: 7px;
  }

  #stickyDivie button {
    background-color: #4e73df;
    color: white;
  }
</style>
