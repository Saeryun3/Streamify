    package com.Streamify.Model;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.util.Set;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "[Video]")
    public class Video {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long videoId;
        @Column(name = "title")
        private String title;
        @Column(name = "description")
        private String description;
        @Column(name = "image")
        private String image;
        @Column(name = "videoUrl")
        private String videoUrl;
        @Column (name = "Type")
        private Boolean type;
        @OneToMany(mappedBy = "video", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
        private Set<Review> review;
        @ManyToMany(mappedBy = "videos", fetch = FetchType.EAGER)
        private Set<Category> categories;
    }
