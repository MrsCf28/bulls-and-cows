// update the class
class BadRequestException extends Exception {

    protected String message;

    public BadRequestException(String message) {
        super(message);
    }

}