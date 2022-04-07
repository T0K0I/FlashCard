<script>
    let naam = "nun und";
    let descriptie =
        "Using color to add meaning only provides a visual indication, which will not be conveyed to users of assistive technologies – such as screen readers. Ensure that information denoted by the color is either obvious from the content itself (e.g. the visi";

    let cardGeflipt = true;

    function rateBad() {
        flipCard();
    }

    function rateGood() {
        flipCard();
    }

    function flipCard() {
        if (cardGeflipt) {
            cardGeflipt = false;
        } else {
            cardGeflipt = true;
        }
    }
</script>

<br /><br />
<div class="card" id="spelcard">
    <br />

    {#if cardGeflipt}
        <h3>{naam}</h3>

        <img
            src="https://post.medicalnewstoday.com/wp-content/uploads/sites/3/2020/02/322868_1100-800x825.jpg"
            alt=""
            id="afbeeldingSpel"
        />

        <br />

        <div>
            <button class="btn-warning" on:click={flipCard}>flip</button>
        </div>
    {:else}
        <div class="paddingDiv" />
        <p>{descriptie}</p>

        <div class="paddingDiv" />

        <div>
            <button class="btn-success" on:click={rateGood}>goed</button>
            <button class="btn-danger" on:click={rateBad}>fout</button>
        </div>
    {/if}
</div>

<style>
    #spelcard {
        height: 550px;
        text-align: center;
        color: rgb(43, 43, 43);
    }

    #spelcard button {
        border: none;
        width: 48%;
        height: 35px;
        border-radius: 5px;
    }

    #afbeeldingSpel {
        height: 350px;
        width: fit-content;
        margin-left: auto;
        margin-right: auto;
    }

    .paddingDiv {
        height: 175px;
    }
</style>
