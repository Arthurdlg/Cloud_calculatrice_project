<template>
  <div id="app">
    <CalculatriceComponent />
  </div>
</template>

<script>
import CalculatriceComponent from "./components/CalculatriceComponent.vue";

export default {
  components: {
    CalculatriceComponent,
  },
};
</script>

<style>
#app {
  font-family: Arial, sans-serif;
  text-align: center;
  margin-top: 50px;
}
</style>
