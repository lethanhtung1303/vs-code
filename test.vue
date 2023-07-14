<template>
    <div>
        <!-- Content of your page -->
        <ValidationObserver ref="observer">
            <!-- Your form content -->
        </ValidationObserver>
    </div>
</template>
<script lang="ts">
import { ValidationObserver } from 'vee-validate';

console.time('Execution Time');
const usedBefore = process.memoryUsage().heapUsed;

// Call the function to be timed and to measure memory usage here

const usedAfter = process.memoryUsage().heapUsed;
console.timeEnd('Execution Time');
console.log(`Memory used Before: ${usedBefore / 1024 / 1024} MB`);
console.log(`Memory used After: ${usedAfter / 1024 / 1024} MB`);
console.log(`Memory used: ${(usedAfter - usedBefore) / 1024 / 1024} MB`);

async function myFunction() {
    const value = await (
        this.$refs.observer as InstanceType<typeof ValidationObserver>
    ).validate();
    if (!value) {
        // my logic
    }
}
</script>
