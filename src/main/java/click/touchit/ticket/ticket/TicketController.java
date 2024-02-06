package click.touchit.ticket.ticket;

import click.touchit.ticket.ticket.dto.TicketRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

  private final TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @GetMapping("ping")
  public ResponseEntity<Map<String, Object>> ping() {
    return ResponseEntity.ok(Map.of("response","Pong"));
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> createTicket(@RequestBody TicketRequest request) {
    return ticketService.createTicket(request);
  }

  @GetMapping
  public ResponseEntity<Map<String, Object>> getAll() {
    return ticketService.getAllTickets();
  }
}
