import { defineStore } from "pinia";

export const useToastStore = defineStore({
    id: "toast",

    state: () => ({
        dismiss: false as boolean,
    }),

    getters: {

    },

    actions: {
        dismissToast: function (type: string) {
            this.dismiss = true;
        },

        toastTimeOut: function (): void {
            setTimeout(this.dismissToast, 6000);
        }
    }
});