<template>
  <div class="flex flex-col items-center justify-center min-h-screen bg-gray-100">
    <div class="bg-white shadow-lg rounded-lg p-8 w-96">
      <h1 class="text-2xl font-bold text-center text-gray-700 mb-4">Calculatrice</h1>

      <!-- Inputs -->
      <div class="flex justify-between mb-4">
        <input v-model="nombre1" type="number" placeholder="Nombre 1"
               class="w-1/2 p-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 mr-2">
        <input v-model="nombre2" type="number" placeholder="Nombre 2" v-if="showInputN2"
               class="w-1/2 p-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
      </div>

      <!-- Opérations -->
      <div class="grid grid-cols-2 gap-2">
        <button v-for="op in operations" :key="op.value" @click="calculer(op.value)"
                class="bg-blue-500 text-white p-2 rounded-lg hover:bg-blue-600 transition">
          {{ op.label }}
        </button>
      </div>

      <!-- Résultat -->
      <h2 v-if="result !== null" class="mt-4 text-xl font-semibold text-gray-700 text-center">
        Résultat : <span class="text-blue-600">{{ result }}</span>
      </h2>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      nombre1: null,
      nombre2: null,
      result: null,
      showInputN2: true,
      // gatewayURL: "http://localhost:8080",
      gatewayURL: "http://calculatrice-service:80",
      operations: [
        { label: "+", value: "addition" },
        { label: "-", value: "soustraction" },
        { label: "x", value: "multiplication" },
        { label: "/", value: "division" },
        { label: "√", value: "racine" },
        { label: "n1^n2", value: "puissance" },
      ],
    };
  },
  methods: {
    async calculer(operation) {
      try {
        let url = `${this.gatewayURL}/calculatrice/${operation}?a=${this.nombre1}`;

        if (operation === "racine") {
          this.showInputN2 = false;
        } else {
          this.showInputN2 = true;
          url += `&b=${this.nombre2}`;
        }

        const response = await fetch(url);

        if (!response.ok) {
          throw new Error(`Erreur HTTP : ${response.status}`);
        }

        this.result = await response.json();
      } catch (error) {
        console.error("Erreur :", error);
        this.result = "Erreur de communication avec le serveur.";
      }
    }
  }
};
</script>

