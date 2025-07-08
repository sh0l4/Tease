package com.example.motivationalquotes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class QuoteController {
    
    private final List<String> quotes = Arrays.asList(
        "The only way to do great work is to love what you do. - Steve Jobs",
        "Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill",
        "Believe you can and you're halfway there. - Theodore Roosevelt",
        "The future belongs to those who believe in the beauty of their dreams. - Eleanor Roosevelt",
        "The only limit to our realization of tomorrow is our doubts of today. - Franklin D. Roosevelt",
        "Don't watch the clock; do what it does. Keep going. - Sam Levenson",
        "The way to get started is to quit talking and begin doing. - Walt Disney",
        "Everything you've ever wanted is on the other side of fear. - George Addair",
        "The best time to plant a tree was 20 years ago. The second best time is now. - Chinese Proverb",
        "Your time is limited, don't waste it living someone else's life. - Steve Jobs"
    );
    
    private final Random random = new Random();

    @GetMapping("/")
    public String getQuote(Model model) {
        // Get a random quote
        String randomQuote = quotes.get(random.nextInt(quotes.size()));
        
        // Get server IP address
        String ipAddress = "Unknown";
        try {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Get the username from the system
        String username = System.getProperty("user.name");
        
        model.addAttribute("quote", randomQuote);
        model.addAttribute("ipAddress", ipAddress);
        model.addAttribute("username", username);
        return "index";
    }
}
