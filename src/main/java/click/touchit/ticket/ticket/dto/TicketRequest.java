package click.touchit.ticket.ticket.dto;

import click.touchit.ticket.ticket.TicketStatus;

import java.io.Serializable;

/**
 * DTO for {@link click.touchit.ticket.ticket.Ticket}
 */
public record TicketRequest(String fullName, String email, String phone, String ticketId) implements Serializable {
}