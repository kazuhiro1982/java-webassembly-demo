<script lang="ts" context="module">
    declare const TeaVM: any;
</script>

<script lang="ts">
    import { onMount } from "svelte";

    let x: number;
    let y: number;
    let result: number;
    let exports: any;

    onMount(async () => {
        const teavm = await TeaVM.wasm.load("app.wasm")
        const instance = teavm.instance;
        exports = instance.exports;
        teavm.main();
    });

    const calc = () => {
        result = exports.mul(x, y);
    }
</script>

<input type="number" bind:value={x} />
<input type="number" bind:value={y} />
<button on:click={calc}>計算</button>

{#if result !== undefined}
    <p>結果: {result}</p>
{/if}