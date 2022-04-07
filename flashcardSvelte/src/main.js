import App from './App.svelte';

const app = new App({
	target: document.body,
	props: {
		naam: '{Je moeder slikt BBC}'
	}
});

export default app;