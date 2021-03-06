package nextbook.ui;

import nextbook.io.IO;
import nextbook.domain.ClueService;
import nextbook.domain.Clue;
import nextbook.domain.Book;
import nextbook.domain.Video;
import nextbook.domain.Blog;

import java.util.ArrayList;

public class Update extends Command {

    private ClueService clueService;

    public Update(IO io, ClueService clueService) {
        super(io);
        this.clueService = clueService;
    }

    @Override
    public void execute() {
        ArrayList<Clue> clues = clueService.readClues();
        for (int id = 1; id <= clues.size(); id++) {
            io.print("id (" + id + "), " + clues.get(id - 1));;
        }
        int id = io.readInt("Give id of clue to update");

        if (id < 1 || id > clues.size()) {
            io.print("Invalid index");
            return;
        }
        Clue clue = clues.get(id - 1);

        if (clue instanceof Book) {
            updateBook(clue);
        }

        if (clue instanceof Video) {
            updateVideo(clue);
        }
      
        if (clue instanceof Blog) {
            updateBlog(clue);
        }
    }

    public void updateBook(Clue clue) {
        Book book = (Book) clue;
        if (io.readLine("Do you want change name of book (y/n)").equals("y")) {
            book.setName(io.readLine("Give new name of the book"));
        }
        if (io.readLine("Do you want change author of book (y/n)").equals("y")) {
            book.setAuthor(io.readLine("Give new author of the book"));
        }
        if (io.readLine("Do you want change ISBN of book (y/n)").equals("y")) {
            book.setIsbn(io.readLine("Give new ISBN of the book"));
        }
        if (io.readLine("Do you want change comments of book (y/n)").equals("y")) {
            book.setComment(io.readLine("Give new comments of the book (all in same line)"));
        }
        if (io.readLine("Do you want change publish year of book (y/n)").equals("y")) {
            book.setYearPublished(io.readInt("Give new publish year of the book"));
        }

        clueService.update(book);
        io.print("Updated successfully");
    }

    public void updateVideo(Clue clue) {
        Video video = (Video) clue;
        if (io.readLine("Do you want change name of video (y/n)").equals("y")) {
            video.setName(io.readLine("Give new name of the video"));
        }

        if (io.readLine("Do you want change link of video (y/n)").equals("y")) {
            video.setLink(io.readLine("Give new link of the video"));
        }
        if (io.readLine("Do you want change time of video (y/n)").equals("y")) {
            video.setTime(io.readInt("Give new time of the video"));
        }
        clueService.update(video);
        io.print("Updated successfully");

    }
  
    public void updateBlog(Clue clue) {
        Blog blog = (Blog) clue;
        if (io.readLine("Do you want to change the name of the blog post (y/n)").equals("y")) {
            blog.setName(io.readLine("Give new name of the post"));
        }
        if (io.readLine("Do you want to change the author of the blog post (y/n)").equals("y")) {
            blog.setAuthor(io.readLine("Give new author of the post"));
        }
        if (io.readLine("Do you want to change the link of the blog post (y/n)").equals("y")) {
            blog.setLink(io.readLine("Give new link of the post"));
        }
        if (io.readLine("Do you want to change the comments of blog post (y/n)").equals("y")) {
            blog.setComment(io.readLine("Give new comments of the post (all in same line)"));
        }
        clueService.update(blog);
        io.print("Updated successfully");
    }
}
