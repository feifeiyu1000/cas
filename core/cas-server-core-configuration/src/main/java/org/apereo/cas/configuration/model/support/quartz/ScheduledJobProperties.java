package org.apereo.cas.configuration.model.support.quartz;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.io.Serializable;

/**
 * This is {@link ScheduledJobProperties}.
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
public class ScheduledJobProperties implements Serializable {
    private static final long serialVersionUID = 9059671958275130605L;

    @NestedConfigurationProperty
    private SchedulingProperties schedule = new SchedulingProperties();

    public ScheduledJobProperties() {
    }

    public ScheduledJobProperties(final String startDelay, final String repeatInterval) {
        schedule.setEnabled(true);
        schedule.setStartDelay(startDelay);
        schedule.setRepeatInterval(repeatInterval);
    }

    public SchedulingProperties getSchedule() {
        return schedule;
    }

    public void setSchedule(final SchedulingProperties schedule) {
        this.schedule = schedule;
    }
}
