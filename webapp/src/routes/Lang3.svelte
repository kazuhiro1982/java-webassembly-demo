<script lang="ts" context="module">
    declare function cheerpjInit(): void;
    declare function cheerpjRunLibrary(name: string): any;
</script>

<script lang="ts">
    import { onMount } from "svelte";

    let text = "";
    let hashValue = "";
    let lib: any;
    let disabled = true;
    onMount(async () => {
        disabled = true;

        // 初期化処理
        await cheerpjInit();

        // ライブラリをロード
        lib = await cheerpjRunLibrary("/app/commons-lang3-3.14.0.jar");

        console.log('libary loaded');
        disabled = false;
    });

    const hash = async (text: string) => {
        try {
            const HashCodeBuilder = await lib.org.apache.commons.lang3.builder.HashCodeBuilder;
            const builder = await new HashCodeBuilder();
            await builder.append(text);
            hashValue = await builder.toHashCode();

        } catch (e: any) {
            console.log("Unknown error: " + (await e));
        }
    }
</script>

<div>
    <label for="textInput">Original Text:</label>
    <input type="text" id="textInput" bind:value={text} on:change={() => hash(text)} {disabled} />
</div>
<span>Hash Value: {hashValue}</span>