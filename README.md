# JavaとWebAssembly デモ用コード

[JavaDoでしょう#25](https://javado.connpass.com/event/322518/) で発表したデモコード

## Demo - TeaVM

1. JavaのサンプルコードをBuildしてwasmバイナリを生成

```shell
cd teavm
./gradlew build
```

2. 生成されたwasmバイナリの中身を確認

```shell
wasm2wat app/build/generated/teavm/wasm/app.wasm
```

3. 生成されたwasmバイナリをサンプルWebAppにデプロイ

```shell
cd ..
cp teavm/app/build/generated/teavm/wasm/app.wasm* webapp/static/
```

4. サンプルWebAppを起動

- `webapp/src/routes/+page.svelte`をエディタで開く
- `app.wasm-runtime.js` をインポート

```js
<svelte:head>
	<title>WebAssembly Demo App</title>
	<meta name="description" content="WebAssembly Demo App" />
	<script src="./app.wasm-runtime.js"></script> <!-- ここのコメントアウトを外す -->
	<!-- <script src="https://cjrtnc.leaningtech.com/3.0/cj3loader.js"></script> -->
</svelte:head>
```

- 起動

```shell
cd webapp
npm install
npm run dev
```

5. 起動したURLにアクセス

## Demo - ライブラリモード

1. `webapp/src/routes/+page.svelte`をエディタで開く
2. `cj3loader.js` をインポート

```js
<svelte:head>
	<title>WebAssembly Demo App</title>
	<meta name="description" content="WebAssembly Demo App" />
	<!-- <script src="./app.wasm-runtime.js"></script> -->
	<script src="https://cjrtnc.leaningtech.com/3.0/cj3loader.js"></script> <!-- ここのコメントアウトを外す -->
</svelte:head>
```

3. `<Lang3/>` コンポーネントを組み込む

```js
<script lang="ts">
    import Lang3 from "./Lang3.svelte";
</script>

...
<h2>
  <!-- <TeaVm/> -->
  <Lang3/> <!-- インポート -->
  <!-- <Swing/> -->
</h2>

```

4. ブラウザをリロード

## Demo - Applicationモード

1. Swingのサンプルコードをビルド

```
cd swing
./gradlew build
```

2. ビルドしたSwingアプリをサンプルWebAppにデプロイ

```shell
cd ..
cp swing/app/build/libs/swing-sample.jar webapp/static/
```

3. `<Swing/>` コンポーネントを組み込む

```js
<script lang="ts">
    import Swing from "./Swing.svelte";
</script>

...
<h2>
  <!-- <TeaVm/> -->
  <!-- <Lang3/> -->
  <Swing/> <!-- インポート -->
</h2>

```

4. ブラウザをリロード
