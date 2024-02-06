package click.touchit.ticket.ticket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "email")
  private String email;

  @Column(name = "phone")
  private String phone;

  @Column(name = "ticket_id")
  private String ticketId;

  @Enumerated(EnumType.STRING)
  @Column(name = "ticket_status")
  private TicketStatus ticketStatus;

  @Column(name = "date_created")
  private LocalDateTime dateCreated;

  public void setDateCreated(LocalDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public void setTicketStatus(TicketStatus ticketStatus) {
    this.ticketStatus = ticketStatus;
  }

  public void setTicketId(String ticketId) {
    this.ticketId = ticketId;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}
