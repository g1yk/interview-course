class LinkedListStack {
    constructor() {
        this.head = null;
    }

    push(value) {
        this.head = { value: value,  next: this.head }
    }

    pop() {
        const result = this.head.value;
        this.head = this.head.next;
        return result;
    }
}
