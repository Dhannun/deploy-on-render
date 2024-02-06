package click.touchit.ticket.ticket;

import click.touchit.ticket.ticket.dto.TicketRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

import static click.touchit.ticket.ticket.TicketStatus.PENDING;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;

@Service
@RequiredArgsConstructor
public class TicketService {

  private final TicketRepository ticketRepository;

  public ResponseEntity<Map<String, Object>> createTicket(TicketRequest request) {
    Ticket ticket = Ticket.builder()
        .fullName(request.fullName())
        .ticketId(request.ticketId())
        .dateCreated(now())
        .ticketStatus(PENDING)
        .phone(request.phone())
        .email(request.email())
        .build();

    Ticket savedTicket = ticketRepository.save(ticket);

    return new ResponseEntity<>(Map.of("response", savedTicket), CREATED);
  }

  public ResponseEntity<Map<String, Object>> getAllTickets() {
    return ResponseEntity.ok(Map.of("response", ticketRepository.findAll()));
  }
}
