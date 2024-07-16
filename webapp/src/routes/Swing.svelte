<script lang="ts" context="module">
    declare function cheerpjInit(): void;
    declare function cheerpjCreateDisplay(w: number, h: number): any;
    declare function cheerpjRunJar(name: string): any;
</script>

<script lang="ts">
    import { onMount } from "svelte";

    onMount(async () => {
        // 初期化
        await cheerpjInit();

        // 描画Window生成
        cheerpjCreateDisplay(400, 400);

        // Jarのロード
        await cheerpjRunJar("/app/swing-sample.jar");
        console.log('application loaded');
    });
</script>