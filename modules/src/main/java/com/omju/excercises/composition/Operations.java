package com.omju.excercises.composition;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.List;

public class Operations {
    public static void main(String[] args) {
        System.out.println("===== EXAMPLE 1 =====");
        Function<Integer, Integer> operation1 = x -> {
            System.out.println("Inner operation 1 function");
            return x * 3;
        };

        // El método compose ejecuta la función en la que fue definida y después ejecuta la función en la cual se mandó a llamar.
        Function<Integer, Integer> operation2 = operation1.compose(y -> {
            System.out.println("Inner operation 2 function");
            return y - 1;
        });

        // El método andThen ejecuta primero la función en la cual se llama el método y después en la que fue definida.
        Function<Integer, Integer> operation3 = operation2.andThen(z -> {
            System.out.println("Inner operation 3 function");
            return z * z;
        });

        System.out.println("The result is: " + operation3.apply(5));

        System.out.println("\n\n===== EXAMPLE 2 =====");
        Function<String, String> operation1ConnectionVerify = url -> {
            System.out.println("Operation 1: Verify the DB connection...");
            String[] dbString = url.split("\\|");

            if (dbString[0].contains("dbcDriver")) {
                return dbString[1];
            } else {
                return "";
            }
        };

        Function<String, Boolean> operation2ExecuteQuery = operation1ConnectionVerify.andThen(query -> {
            System.out.println("Operation 2: Execute query... ");
            return query.contains("with ur");
        });

        Function<String, Boolean> operation3CloseDB = operation2ExecuteQuery.andThen(isSuccess -> {
            if (isSuccess) {
                System.out.println("Operation 3: Connection closed!!");
                return true;
            }

            return false;
        });

        System.out.println("The result is: " + operation3CloseDB.apply("jdbcTemplate:dbcDriver:omju:omju90/1234|select * from costumer with ur"));

        example3();
    }

    private static void example3() {
        System.out.println("\n\n===== EXAMPLE 3 =====");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Article article1 = new Article("The origin of the lambs", "Peter Lamber", "Scientist", sdf.parse("16/06/1997"));
            Article article2 = new Article("How works own blood", "Daniela Zamudio", "Medicine", sdf.parse("01/09/2018"));
            Article article3 = new Article("The future of Java with the functional programing", "Omar Juarez", "Informatics", sdf.parse("04/11/2017"));
            Article article4 = new Article("The 5G is not enough", "Anthony Star", "Communications", sdf.parse("08/03/2019"));
            Article article5 = new Article("The vaccine Pfizer es secure?", "Areliz Villeda", "Medicine", sdf.parse("15/11/2021"));
            Article article6 = new Article("Why ReactJS is better that AngularJS", "Majo Ledesma", "Informatics", sdf.parse("07/08/2014"));
            Article article7 = new Article("Healing eyes", "Daniela Zamudio", "Medicine", sdf.parse("20/09/2015"));
            Article article8 = new Article("Foot that make miracles", "Daniela Zamudio", "Medicine", sdf.parse("14/06/2019"));
            Article article9 = new Article("Creatine in the sleep", "Daniela Zamudio", "Medicine", sdf.parse("20/01/2022"));
            Article article10 = new Article("The broken heart syndrome", "Daniela Zamudio", "Medicine", sdf.parse("03/05/2022"));


            List<Article> allArticles = Article.gelAllArticles(article1, article2, article3, article4, article5, article6, article7, article8, article9, article10);

            // Find by autor.
            BiFunction<String, List<Article>, List<Article>> byAutor = (nameAutor, articles) -> articles.stream().filter(article -> article.getAutor().equals(nameAutor)).collect(Collectors.toList());

            // Find by tag.
            BiFunction<String, List<Article>, List<Article>> byTag = (tag, articles) -> articles.stream().filter(article -> article.getTag().contains(tag)).collect(Collectors.toList());

            // Sort the articles by date, to the newest from the oldest.
            Function<List<Article>, List<Article>> sortByDate = articles -> articles.stream().sorted((articleA, articleB) -> articleB.getPublished().compareTo(articleA.getPublished())).collect(Collectors.toList());

            // Get the first article.
            Function<List<Article>, Optional<Article>> findFirst = articles -> articles.stream().findFirst();

            // Get the newest article.
            Function<List<Article>, Optional<Article>> newest = findFirst.compose(sortByDate);

            // The newest by tag.
            BiFunction<String, List<Article>, Optional<Article>> newestByTag = byTag.andThen(newest);

            // The newest by autor.
            BiFunction<String, List<Article>, Optional<Article>> newestByAutor = byAutor.andThen(newest);

            System.out.println("The newest article: " + newest.apply(allArticles));
            System.out.println("The newest article by tag: " + newestByTag.apply("Informatics", allArticles));
            System.out.println("The newest article by autor: " + newestByAutor.apply("Daniela Zamudio", allArticles));

        } catch (Exception e) {
            System.out.println("Error in the operation " + e.getMessage());
            e.printStackTrace();
        }
    }
}
