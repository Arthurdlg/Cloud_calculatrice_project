<template>
  <div class="flex flex-col items-center justify-center min-h-screen bg-gray-100">
    <div class="bg-white shadow-lg rounded-lg p-8 w-96">
      <h1 class="text-2xl font-bold text-center text-gray-700 mb-4">Calculatrice</h1>

      <!-- Inputs -->
      <div class="flex justify-between mb-4">
        <input v-model="nombre1" type="number" placeholder="Nombre 1"
               class="w-1/2 p-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 mr-2">
        <input v-model="nombre2" type="number" placeholder="Nombre 2"
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
import axios from "axios";

export default {
  data() {
    return {
      nombre1: null,
      nombre2: null,
      result: null,
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
        const params = { a: this.nombre1, b: this.nombre2 };

        // Si l'opération est racine, on envoie seulement "a"
        if (operation === "racine") {
          params.b = undefined;
        }

        const response = await axios.get(`http://localhost:8080/calculatrice/${operation}`, { params });

        this.result = response.data;
      } catch (error) {
        console.error("Erreur :", error);
        this.result = "Erreur de communication avec le serveur.";
      }
    }
  }
};
</script>
