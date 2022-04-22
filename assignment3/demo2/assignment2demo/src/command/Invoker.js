class Invoker{
    invoke(command) {
        command.execute();
    }
}

const InvokerInstance = new Invoker();

export default InvokerInstance;