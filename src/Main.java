
import java.sql.Timestamp;
import java.util.Date;

//Defining the table
@Entity
@Table(name = "wishlist")
public class WishList {

    //id column
    //auto generated & auto incremented
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //user_id column
    @Column(name = "user_id")
    private @NotBlank Integer userId;

    //product_id column
    @Column(name = "product_id")
    private @NotBlank Long productId;

    //created_date column
    @Column(name = "created_date")
    private Date createdDate;

    //Object of product class to store the product information
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    public WishList() {
    }


    public WishList(Integer userId, Long productId) {
        this.userId = userId;
        this.productId=productId;
        //storing the current data & time in created_date column
        this.createdDate = new Date();
    }

    //Setter & Getters

    public Integer getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}