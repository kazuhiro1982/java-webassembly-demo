<script lang="ts">
    import TeaVm from "./TeaVM.svelte";
</script>

<svelte:head>
	<title>WebAssembly Demo App</title>
	<meta name="description" content="WebAssembly Demo App" />
	<!-- <script src="./app.wasm-runtime.js"></script> -->
	<!-- <script src="https://cjrtnc.leaningtech.com/3.0/cj3loader.js"></script> -->
</svelte:head>

<section>
	<h2>
		<TeaVm/>
		<!-- <Lang3/> -->
		<!-- <Swing/> -->
	</h2>

</section>

<style>
	section {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		flex: 0.6;
	}
</style>
