public class TestCartScreen extends Application {
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
        CartController cartController = new CartController(cart);
        fxmlLoader.setController(cartController);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Cart");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        cart = new Cart();
        // Thêm các media vào cart ở đây
        launch(args);
    }
}